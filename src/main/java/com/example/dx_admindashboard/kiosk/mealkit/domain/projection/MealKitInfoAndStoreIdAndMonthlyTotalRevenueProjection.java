package com.example.dx_admindashboard.kiosk.mealkit.domain.projection;

public interface MealKitInfoAndStoreIdAndMonthlyTotalRevenueProjection {
    Long getMealKitId();
    String getMealKitName();
    String getMealKitClassification();
    String getMealKitFoodClassification();
    Long getStoreId();
    Integer getMealKitPrice();
    Long getMonthlyTotalRevenue();
}
