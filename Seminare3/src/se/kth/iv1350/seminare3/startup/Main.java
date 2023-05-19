package se.kth.iv1350.seminare3.startup;

/*Starts the application*/

import se.kth.iv1350.seminare3.Integration.FileLogger;
import se.kth.iv1350.seminare3.Integration.InventorySystem;
import se.kth.iv1350.seminare3.controller.Controller;
import se.kth.iv1350.seminare3.model.ItemInformation;
import se.kth.iv1350.seminare3.view.View;

public class Main {
    //Creates controller object contr, view object and runs method runFakeExecution in view.
    public static void main(String[] args) {
        Controller contr = new Controller(new FileLogger());
        View view = new View(contr,new FileLogger());
        view.runFakeExecution();
    }

}
