package com.example.dx_admindashboard.kiosk.mealkit.domain.projection;

public interface MealKitAndStoreIdAndMealKitCountProjection {
    Long getMealKitId();
    String getMealKitName();
    String getMealKitClassification();
    String getMealKitFoodClassification();
    Integer getMealKitPrice();
    Long getStoreId();
    Integer getMealKitCount();
}
