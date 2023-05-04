package se.kth.iv1350.seminare3.model;
//ItemInformation contains itemPrice, itemDescription, itemIdentifier, itemVATRate and quantity
public class ItemInformation {
    public double itemPrice;
    public String itemDescription;
    public int itemIdentifier;
    public double itemVATRate;
    public int quanitity;

    public ItemInformation(double itemPrice,String itemDescription,int itemIdentifier,double itemVATRate,int quanitity ) {
        this.itemPrice = itemPrice;
        this.itemDescription = itemDescription;
        this.itemIdentifier = itemIdentifier;
        this.itemVATRate = itemVATRate;
        this.quanitity = quanitity;
    }
}
