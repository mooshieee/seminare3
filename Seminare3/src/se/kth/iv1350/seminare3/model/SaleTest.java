package se.kth.iv1350.seminare3.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SaleTest {


    Sale testSale = new Sale();
    double runningTotal;
    ItemInformation testItem = new ItemInformation(25, "Felix köttbullar", 1, 0.2,1);
    ItemInformation testItem2 = new ItemInformation(20, "Nocco", 2, 0.2,1);

    //ArrayList<ItemInformation> itemPurchaseList = new ArrayList<>();

    //Test checks that the first item is added correctly in the itemPurchaseList
    @Test
    void updateSaleFirstItem() {

        runningTotal = testSale.updateSale(testItem,testSale);
        assertTrue((testSale.itemPurchaseList.get(0) == testItem), "First item in purchase list does not match purchased item");
        assertTrue((runningTotal == 25),"runningTotal not correct amount");

    }
    //Test checks when another item with different itemIdentifier is purchased
    //that it is added correctly in the itemPurchaseList.
    @Test
    void updateSaleOtherItems() {
        testSale.updateSale(testItem,testSale);
        runningTotal = testSale.updateSale(testItem2, testSale);

        assertTrue((testSale.itemPurchaseList.get(0) == testItem),"First item in purchase list does not match ");
        assertTrue((testSale.itemPurchaseList.get(1) == testItem2),"Second item in purchase list does not match");
        assertTrue((runningTotal == 45),"runnintTotal not correct amount");
    }
    /*Test checks that when purchased item is already in itemPurchaseList,
    it does not add it to itemPurchaseList. Also checks that runningTotal is correct
    */
    @Test
    void updateSaleDifferentQuantity(){
        testSale.updateSale(testItem,testSale);
        testSale.updateSale(testItem2, testSale);
        testSale.itemPurchaseList.get(0).quanitity = 2;
        runningTotal = testSale.updateSale(testItem,testSale);

        assertTrue((testSale.itemPurchaseList.get(0) == testItem),"First item in purchase list does not match ");
        assertTrue((testSale.itemPurchaseList.get(1) == testItem2),"Second item in purchase list does not match");
        assertTrue((testSale.itemPurchaseList.size() == 2),"Size of itemPurchaseList is not correct");
        assertTrue((runningTotal == 70),"runningTotal not correct amount");
    }

}