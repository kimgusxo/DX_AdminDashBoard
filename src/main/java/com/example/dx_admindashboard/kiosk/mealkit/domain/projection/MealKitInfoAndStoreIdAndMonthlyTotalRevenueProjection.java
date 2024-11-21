package com.example.dx_admindashboard.kiosk.mealkit.domain.projection;

// 이새끼 머임??
public interface MealKitInfoAndStoreIdAndMonthlyTotalRevenueProjection {
    Long getMealKitId();
    String getMealKitName();
    String getMealKitClassification();
    String getMealKitFoodClassification();
    Long getStoreId();
    Integer getMealKitPrice();
    Long getMonthlyTotalRevenue();
}
