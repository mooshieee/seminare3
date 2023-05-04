package se.kth.iv1350.seminare3.model;

import java.time.LocalTime;
import java.util.ArrayList;

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

    public double updateSale(ItemInformation itemInfo, Sale sale) {
        //runningTotal = runningTotal + itemInfo.itemPrice*itemInfo.quanitity;
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
