package se.kth.iv1350.seminare3.view;

import se.kth.iv1350.seminare3.model.Sale;
import se.kth.iv1350.seminare3.model.SaleObserver;

public class TotalRevenueView implements SaleObserver {

    private double totalRevenue;
    @Override
    public void CalculateTotalRevenue(Sale sale) {
        totalRevenue = totalRevenue + sale.runningTotal;
        System.out.println("Total revenue: "+totalRevenue);


    }
}
