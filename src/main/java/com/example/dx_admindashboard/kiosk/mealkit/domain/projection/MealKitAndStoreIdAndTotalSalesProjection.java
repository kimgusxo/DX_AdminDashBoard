package com.example.dx_admindashboard.kiosk.mealkit.domain.projection;

public interface MealKitAndStoreIdAndTotalSalesProjection {
    Long getMealKitId();
    String getMealKitName();
    String getMealKitClassification();
    String getMealKitFoodClassification();
    Long getStoreId();
    Integer getMealKitPrice();
    Long getTotalSales(); // 연도별 총 판매량
}
