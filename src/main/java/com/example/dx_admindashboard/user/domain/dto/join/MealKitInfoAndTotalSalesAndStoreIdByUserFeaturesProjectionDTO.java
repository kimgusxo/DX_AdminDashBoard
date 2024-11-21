package com.example.dx_admindashboard.user.domain.dto.join;

import com.example.dx_admindashboard.user.domain.projection.MealKitInfoAndTotalSalesAndStoreIdByUserFeaturesProjection;

public record MealKitInfoAndTotalSalesAndStoreIdByUserFeaturesProjectionDTO(
        Long mealKitId,
        String mealKitName,
        String mealKitClassification,
        String mealKitFoodClassification,
        Integer mealKitPrice,
        Long totalSales,
        Long storeId
) {
    public static MealKitInfoAndTotalSalesAndStoreIdByUserFeaturesProjectionDTO from(MealKitInfoAndTotalSalesAndStoreIdByUserFeaturesProjection projection) {
        return new MealKitInfoAndTotalSalesAndStoreIdByUserFeaturesProjectionDTO(
                projection.getMealKitId(),
                projection.getMealKitName(),
                projection.getMealKitClassification(),
                projection.getMealKitFoodClassification(),
                projection.getMealKitPrice(),
                projection.getTotalSales(),
                projection.getStoreId()
        );
    }
}

