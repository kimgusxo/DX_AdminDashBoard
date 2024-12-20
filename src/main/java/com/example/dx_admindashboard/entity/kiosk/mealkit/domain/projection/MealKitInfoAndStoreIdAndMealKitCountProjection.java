package com.example.dx_admindashboard.entity.kiosk.mealkit.domain.projection;

public interface MealKitInfoAndStoreIdAndMealKitCountProjection {
    Long getMealKitId();
    String getMealKitName();
    String getMealKitClassification();
    String getMealKitFoodClassification();
    Integer getMealKitPrice();
    Long getStoreId();
    Integer getMealKitCount();
}
