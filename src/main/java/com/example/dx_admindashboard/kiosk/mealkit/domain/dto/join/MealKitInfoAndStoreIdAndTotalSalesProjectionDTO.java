package com.example.dx_admindashboard.kiosk.mealkit.domain.dto.join;

import com.example.dx_admindashboard.kiosk.mealkit.domain.projection.MealKitInfoAndStoreIdAndTotalSalesProjection;

public record MealKitInfoAndStoreIdAndTotalSalesProjectionDTO(
        Long mealKitId,
        String mealKitName,
        String mealKitClassification,
        String mealKitFoodClassification,
        Long storeId,
        Integer mealKitPrice,
        Long totalSales
) {
    public static MealKitInfoAndStoreIdAndTotalSalesProjectionDTO from(MealKitInfoAndStoreIdAndTotalSalesProjection projection) {
        return new MealKitInfoAndStoreIdAndTotalSalesProjectionDTO(
                projection.getMealKitId(),
                projection.getMealKitName(),
                projection.getMealKitClassification(),
                projection.getMealKitFoodClassification(),
                projection.getStoreId(),
                projection.getMealKitPrice(),
                projection.getTotalSales()
        );
    }
}
