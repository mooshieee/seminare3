package se.kth.iv1350.seminare3.Integration;

import se.kth.iv1350.seminare3.model.Sale;
import se.kth.iv1350.seminare3.model.SaleObserver;

public class TotalRevenueFileOutput implements SaleObserver {
    private FileLogger fileLogger = new FileLogger("TotalRevenueLog");
    private double totalRevenue;
    @Override
    public void CalculateTotalRevenue(Sale sale) {

        totalRevenue = totalRevenue + sale.runningTotal;

        fileLogger.log("Total revenue:" + totalRevenue);

    }
}
