package com.example.dx_admindashboard.user.domain.projection;

public interface MealKitAndUserFeatureSalesAndStoreIdProjection {
    Long getMealKitId();
    String getMealKitName();
    String getMealKitClassification();
    String getMealKitFoodClassification();
    Integer getMealKitPrice();
    Long getTotalSales();
    Long getStoreId();
}
