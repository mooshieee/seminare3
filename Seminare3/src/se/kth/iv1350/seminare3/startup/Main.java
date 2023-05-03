package se.kth.iv1350.seminare3.startup;

/*Starts the application*/

import se.kth.iv1350.seminare3.Integration.InventorySystem;
import se.kth.iv1350.seminare3.controller.Controller;
import se.kth.iv1350.seminare3.model.ItemInformation;
import se.kth.iv1350.seminare3.view.View;

public class Main {
    public static void main(String[] args) {
        Controller contr = new Controller();
        View view = new View(contr);
        view.runFakeExecution();
    }

}
