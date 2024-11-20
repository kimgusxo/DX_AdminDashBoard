package com.example.dx_admindashboard.user.domain.projection;

public interface MealKitAndUserFeatureSalesProjection {
    Long getMealKitId();
    String getMealKitName();
    String getMealKitClassification();
    String getMealKitFoodClassification();
    Integer getMealKitPrice();
    Long getTotalSales();
}
