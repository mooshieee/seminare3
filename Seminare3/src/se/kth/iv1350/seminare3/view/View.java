package se.kth.iv1350.seminare3.view;

/*Placeholder for real view*/

import se.kth.iv1350.seminare3.controller.Controller;

import java.util.Scanner;

public class View {
    private Controller contr;

    public View(Controller contr) {
        this.contr = contr;
    }

    public void runFakeExecution() {
        contr.startSale();
        System.out.println("A new sale has been started");
        Scanner scannerObj = new Scanner(System.in);
        boolean scanning = true;
        while (scanning) {
            System.out.println("Enter item identifier. Enter 0 to end scanning");
            int itemIdentifier = scannerObj.nextInt();
            if (itemIdentifier != 0) {
                contr.enterItemIdentifier(itemIdentifier);
            }
            else
                scanning = false;

        }
        System.out.println("Enter amount paid");
        double amountPaid = scannerObj.nextDouble();
        double change = contr.enterAmountPaid(amountPaid);
        System.out.println("Your change is: " + change);
        contr.endSale();
    }

}
