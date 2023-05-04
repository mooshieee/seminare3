package se.kth.iv1350.seminare3.Integration;

import org.junit.jupiter.api.Test;
import se.kth.iv1350.seminare3.model.ItemInformation;

import static org.junit.jupiter.api.Assertions.*;
import static se.kth.iv1350.seminare3.Integration.InventorySystem.retrieveItemInformation;

/*
Test for InventorySystem class
 */
class InventorySystemTest {
    ItemInformation testItem = new ItemInformation(25, "Felix köttbullar", 1, 0.2,1);
    ItemInformation[] itemList = InventorySystem.createItemList();

    @org.junit.jupiter.api.Test
    // Tests that method createItemList creates list of ItemInformation objects
    public void testCreateItemList() {

        assertFalse(!(itemList[0] instanceof ItemInformation),"itemList[0] is not a ItemInformation object");


    }

    @org.junit.jupiter.api.Test
    //Tests that retrieveItemInformation returns correct item based on itemIdentifier entered.
    void testRetrieveItemInformation() {

        ItemInformation retrievedItem = retrieveItemInformation(1);
        assertTrue((retrievedItem == itemList[0]), "retrievedItem not correct");

        ItemInformation retrievedItem2 = retrieveItemInformation(30);
        assertTrue((retrievedItem2 == null), "Item found using incorrect itemIdentifier");
    }
}