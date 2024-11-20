package com.example.dx_admindashboard.kiosk.mealkit.projection;

public interface MealKitInfoProjection {
    Long getMealKitId();
    String getMealKitName();
    String getMealKitClassification();
    String getMealKitFoodClassification();
    Integer getMealKitPrice();
    Long getStoreId();
    Integer getMealKitCount();
}
