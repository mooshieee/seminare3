package se.kth.iv1350.seminare3.controller;
/*This is the applications only controller. All calls to the model pass through this class*/

import se.kth.iv1350.seminare3.Integration.InventorySystem;
import se.kth.iv1350.seminare3.model.ItemInformation;
import se.kth.iv1350.seminare3.model.Receipt;
import se.kth.iv1350.seminare3.model.Sale;

import java.util.Scanner;

public class Controller {
    private Sale sale;

    /*Starts a new sale*/

    public void startSale() {
        sale = new Sale();
    }

    public static void printInformation(ItemInformation itemInfo){
        System.out.println("Item description: " + itemInfo.itemDescription);
        System.out.println("Price: " + itemInfo.itemPrice);
        System.out.println("Item VAT rate: " + itemInfo.itemVATRate);
    }
    public void enterItemIdentifier(int itemIdentifier) {
        ItemInformation itemInfo = null;
        boolean itemAdded = false;
        if (sale.itemPurchaseList.size() > 0) {
            for (int i = 0; i < sale.itemPurchaseList.size(); i++) {
                if (sale.itemPurchaseList.get(i).itemIdentifier == itemIdentifier) {
                    System.out.println("ItemIdentfier already used");
                    itemInfo = sale.itemPurchaseList.get(i);
                    sale.itemPurchaseList.get(i).quanitity += 1;
                    printInformation(itemInfo);
                    System.out.println("Running Total: " + sale.updateSale(itemInfo,sale));
                    itemAdded = true;
                    break;
                }
            }
        }
        if (itemAdded == false) {
            if (itemInfo == null) {
                itemInfo = InventorySystem.retrieveItemInformation(itemIdentifier);
            }
            if (itemInfo == null) {
                System.out.println("ItemIdentifier not found");
            } else {
                printInformation(itemInfo);
                System.out.println("Are there multiple of same item? y/n");
                Scanner scannerObj = new Scanner(System.in);
                String answer = scannerObj.nextLine();
                if (answer.equals("y")) {
                    System.out.println("Enter quantity of item?");
                    int quantity = scannerObj.nextInt();
                    itemInfo.quanitity = quantity;
                }
                System.out.println("Running Total: " + sale.updateSale(itemInfo,sale));
            }
        }
    }
    public double enterAmountPaid(double amountPaid) {
        double change =  amountPaid-sale.runningTotal;
        sale.amountPaid = amountPaid;
        sale.change = change;
        return change;

    }
    public void endSale() {
        sale.receipt.printReceipt(sale);
    }



}
