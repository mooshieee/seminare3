package se.kth.iv1350.seminare3.view;
/**
 *@throws ItemIdentifierInvalidException when itemIdentifer is not found in inventoryDatabase.
 */
public class ItemIdentifierInvalidException extends Exception{
    public ItemIdentifierInvalidException(String msg) {
        super(msg);
    }

}
