package se.kth.iv1350.seminare3.Integration;

import se.kth.iv1350.seminare3.model.ItemInformation;

//InventorySystem contains the itemList
public  class InventorySystem {
    //Array of the object ItemInformation is created
    static ItemInformation[] itemList = new ItemInformation[5];
    //createItemList adds ItemInformation objects to itemList
    public static ItemInformation[] createItemList() {

        itemList[0] = new ItemInformation(25, "Felix köttbullar", 1, 0.25,1);
        itemList[1] = new ItemInformation(20, "Nocco", 2, 0.12,1);
        itemList[2] = new ItemInformation(5, "Äpple", 3, 0.06,1);
        itemList[3] = new ItemInformation(35, "Pasta", 4, 0.25,1);
        itemList[4] = new ItemInformation(15, "Mjölk", 5, 0.12,1);

        return itemList;
    }
    //Loops through the itemList and retrieves the item that has the correct itemIdentifier
    public static ItemInformation retrieveItemInformation(int itemIdentifier) {
        ItemInformation []itemList = createItemList();

        ItemInformation itemInfo = null;
        for(int i = 0; i<itemList.length;i++) {
            if (itemList[i] != null) {
                if (itemList[i].itemIdentifier == itemIdentifier) {
                    itemInfo = itemList[i];
                }

            }
        }
        return itemInfo;
    }

}
