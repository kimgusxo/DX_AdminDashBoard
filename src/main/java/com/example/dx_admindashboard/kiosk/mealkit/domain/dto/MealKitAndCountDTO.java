package com.example.dx_admindashboard.kiosk.mealkit.domain.dto;

import com.example.dx_admindashboard.kiosk.mealkit.projection.MealKitAndCountProjection;

public record MealKitAndCountDTO(
        Long mealKitId,
        String mealKitName,
        String mealKitClassification,
        String mealKitFoodClassification,
        Integer mealKitPrice,
        Long storeId,
        Integer mealKitCount
) {
    public static MealKitAndCountDTO from(MealKitAndCountProjection projection) {
        return new MealKitAndCountDTO(
                projection.getMealKitId(),
                projection.getMealKitName(),
                projection.getMealKitClassification(),
                projection.getMealKitFoodClassification(),
                projection.getMealKitPrice(),
                projection.getStoreId(),
                projection.getMealKitCount()
        );
    }
}
