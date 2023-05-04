package se.kth.iv1350.seminare3.model;

import java.time.LocalTime;
import se.kth.iv1350.seminare3.controller.Controller;

//the class Receipt contains saleTime and a method printReceipt
public class Receipt {
    LocalTime saleTime;
    public Receipt(LocalTime saleTime) {
        this.saleTime = saleTime;
    }

    //printReceipt the saleTime, then lops through the itemPurchaseList and print all the items.
    //It also prints runningTotal, amountPaid and change
    public void printReceipt(Sale sale) {
        System.out.println("Receipt");
        System.out.println("Time of purchase: " + saleTime );
        System.out.println("List of items: ");
        for (int i = 0;i < sale.itemPurchaseList.size();i++) {
            Controller.printInformation(sale.itemPurchaseList.get(i));
            System.out.println("Quantity:" + sale.itemPurchaseList.get(i).quanitity);
            System.out.println();
        }
        System.out.println("Total Price: " + sale.runningTotal);
        System.out.println("Total VAT: " + sale.totalVAT);
        System.out.println("Amount Paid: " + sale.amountPaid);
        System.out.println("Change: " + sale.change);
    }

}
