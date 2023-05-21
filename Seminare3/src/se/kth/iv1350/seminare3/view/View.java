package se.kth.iv1350.seminare3.view;


import se.kth.iv1350.seminare3.Integration.FileLogger;
import se.kth.iv1350.seminare3.Integration.TotalRevenueFileOutput;
import se.kth.iv1350.seminare3.controller.Controller;

import java.io.StringWriter;
import java.util.Scanner;
/*Placeholder for real view*/

public class View {
    private Controller contr;
    private FileLogger filelogger;
    public TotalRevenueView totalRevenueView = new TotalRevenueView();



    public View(Controller contr, FileLogger filelogger) {
        this.contr = contr;
        this.filelogger = filelogger;
        TotalRevenueView totalRevenueView = new TotalRevenueView();
        TotalRevenueFileOutput totalRevenueFileOutput = new TotalRevenueFileOutput();
        contr.addSaleObserver(totalRevenueFileOutput);
        contr.addSaleObserver(totalRevenueView);

    }
    /*
    Simulates a sale. Lets user enter itemIdentifiers to add items to sale.
     */
    public void runFakeExecution() {
        contr.startSale();
        System.out.println("A new sale has been started");
        Scanner scannerObj = new Scanner(System.in);
        boolean scanning = true;
        while (scanning) {
            System.out.println("Enter item identifier. Enter 0 to end scanning");
            try {
                int itemIdentifier = scannerObj.nextInt();

                if (itemIdentifier != 0) {

                    contr.enterItemIdentifier(itemIdentifier);

                } else
                    scanning = false;
            } catch (ItemIdentifierInvalidException msg) {
                System.out.println(msg);
                //StringWriter sw = new StringWriter();
                //msg.printStackTrace(fileLogger());
                //String exceptionDetails = sw.toString();
                //msg.printStackTrace();
                //fileLogger.log(msg.printStackTrace());
                //throw ItemIdentifierInvalidException(msg);
            } catch (DatabaseFailureException msg) {
                System.out.println(msg);
                //msg.printStackTrace();

            }

        }
        System.out.println("Enter amount paid");
        double amountPaid = scannerObj.nextDouble();
        double change = contr.enterAmountPaid(amountPaid);
        System.out.println("Your change is: " + change);
        contr.endSale();
        System.out.println("Do you want to start a new sale? y/n");
        Scanner scannerObj2 = new Scanner(System.in);
        String answer = scannerObj2.nextLine();
        if (answer.equals("y")) {
            runFakeExecution();
        }
        else {

        }
    }
}
