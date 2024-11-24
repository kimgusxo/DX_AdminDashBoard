package com.example.dx_admindashboard.entity.kiosk.mealkit.domain.dto.join;

import com.example.dx_admindashboard.entity.kiosk.mealkit.domain.projection.MealKitInfoAndStoreIdAndMealKitCountProjection;

public record MealKitInfoAndStoreIdAndMealKitCountProjectionDTO(
        Long mealKitId,
        String mealKitName,
        String mealKitClassification,
        String mealKitFoodClassification,
        Integer mealKitPrice,
        Long storeId,
        Integer mealKitCount
) {
    public static MealKitInfoAndStoreIdAndMealKitCountProjectionDTO from(MealKitInfoAndStoreIdAndMealKitCountProjection projection) {
        return new MealKitInfoAndStoreIdAndMealKitCountProjectionDTO(
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
