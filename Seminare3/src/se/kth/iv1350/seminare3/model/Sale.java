package se.kth.iv1350.seminare3.model;

import java.time.LocalTime;
import java.util.ArrayList;
//the class Sale contains saletime,receipt, itemPurchaseList, runningTotal, amountPaid and change.
//it also contains the method updateSale
public class Sale {
    private LocalTime saleTime;
    public Receipt receipt;
    public ArrayList<ItemInformation> itemPurchaseList = new ArrayList<ItemInformation>();
    public double runningTotal;
    public double amountPaid;
    public double change;
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
            runningTotal = runningTotal + sale.itemPurchaseList.get(i).itemPrice * sale.itemPurchaseList.get(i).quanitity;

        }
        sale.runningTotal = runningTotal;
        return runningTotal;
    }

}