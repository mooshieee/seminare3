package se.kth.iv1350.seminare3.model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

//the class Sale contains saletime,receipt, itemPurchaseList, runningTotal, amountPaid and change.
//it also contains the method updateSale
public class Sale {
    private LocalTime saleTime;
    public Receipt receipt;
    public ArrayList<ItemInformation> itemPurchaseList = new ArrayList<ItemInformation>();
    public double runningTotal;
    public double totalVATRate;
    public double amountPaid;
    public double totalPriceWithoutVAT;
    public double change;
    private List<SaleObserver> saleObservers = new ArrayList<>();

    public Sale() {
        saleTime = LocalTime.now();
        receipt = new Receipt(saleTime);

    }
    // updateSale adds a new item(of the object ItemInformation) into the itemPurchaseList
    // and updates the running total
    // the method also checks if the new item has the
    // same itemIdentifier as an item that already exists in the itemPurchaseList
    //if that is the case the item is not added
    public double updateSale(ItemInformation itemInfo, Sale sale) {

        runningTotal = 0;
        totalPriceWithoutVAT = 0;
        //Only add item to itemPurchaseList if it doesn't already exist in list.
        boolean foundItem = false;
        for (int i = 0; i < sale.itemPurchaseList.size();i++) {
            if (sale.itemPurchaseList.get(i).itemIdentifier == itemInfo.itemIdentifier) {
                foundItem = true;
            }
        }
        if (!foundItem) {
            sale.itemPurchaseList.add(itemInfo);
        }

        for (int i = 0;i < sale.itemPurchaseList.size();i++) {
            totalPriceWithoutVAT = totalPriceWithoutVAT + (sale.itemPurchaseList.get(i).itemPrice * sale.itemPurchaseList.get(i).quanitity);
            runningTotal = runningTotal + (sale.itemPurchaseList.get(i).itemPrice * (1 + sale.itemPurchaseList.get(i).itemVATRate)) * sale.itemPurchaseList.get(i).quanitity;

        }
        sale.runningTotal = runningTotal;
        sale.totalPriceWithoutVAT = totalPriceWithoutVAT;

        return runningTotal;
    }
    public void calculateTotalVAT(Sale sale) {
        sale.totalVATRate = (sale.runningTotal - sale.totalPriceWithoutVAT) / sale.runningTotal;
    }
    public void updateObservers(Sale sale) {
        for (SaleObserver obs:saleObservers) {
            obs.CalculateTotalRevenue(sale);
        }
    }
    public void addSaleObserver(SaleObserver obs){
        saleObservers.add(obs);
    }
}
