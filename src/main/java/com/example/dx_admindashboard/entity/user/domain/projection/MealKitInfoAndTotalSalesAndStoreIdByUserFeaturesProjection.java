package com.example.dx_admindashboard.entity.user.domain.projection;

public interface MealKitInfoAndTotalSalesAndStoreIdByUserFeaturesProjection {
    Long getMealKitId();
    String getMealKitName();
    String getMealKitClassification();
    String getMealKitFoodClassification();
    Integer getMealKitPrice();
    Long getTotalSales();
    Long getStoreId();
}
