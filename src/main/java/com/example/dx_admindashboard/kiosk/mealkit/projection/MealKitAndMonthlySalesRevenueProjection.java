package com.example.dx_admindashboard.kiosk.mealkit.projection;

public interface MealKitAndMonthlySalesRevenueProjection {
    Long getMealKitId();
    String getMealKitName();
    String getMealKitClassification();
    String getMealKitFoodClassification();
    Long getStoreId();
    Integer getMealKitPrice();
    Long getTotalRevenue(); // 월 단위 총 매출액
}
