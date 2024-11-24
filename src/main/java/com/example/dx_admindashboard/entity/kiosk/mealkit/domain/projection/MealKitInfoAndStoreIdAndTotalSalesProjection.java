package com.example.dx_admindashboard.entity.kiosk.mealkit.domain.projection;

public interface MealKitInfoAndStoreIdAndTotalSalesProjection {
    Long getMealKitId();
    String getMealKitName();
    String getMealKitClassification();
    String getMealKitFoodClassification();
    Long getStoreId();
    Integer getMealKitPrice();
    Long getTotalSales(); // 연도별 총 판매량
}
