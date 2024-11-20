package com.example.dx_admindashboard.kiosk.mealkit.domain.dto;

import com.example.dx_admindashboard.kiosk.mealkit.projection.MealKitInfoProjection;

public record MealKitInfoDTO(
        Long mealKitId,
        String mealKitName,
        String mealKitClassification,
        String mealKitFoodClassification,
        Integer mealKitPrice,
        Long storeId,
        Integer mealKitCount
) {
    public static MealKitInfoDTO from(MealKitInfoProjection projection) {
        return new MealKitInfoDTO(
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
