package com.example.dx_admindashboard.kiosk.mealkit.domain.dto.join;


import com.example.dx_admindashboard.kiosk.mealkit.domain.projection.MealKitInfoAndStoreIdAndMonthlyTotalRevenueProjection;

public record MealKitInfoAndStoreIdAndMonthlyTotalRevenueProjectionDTO(
        Long mealKitId,
        String mealKitName,
        String mealKitClassification,
        String mealKitFoodClassification,
        Long storeId,
        Integer mealKitPrice,
        Long monthlyTotalRevenue
) {
    public static MealKitInfoAndStoreIdAndMonthlyTotalRevenueProjectionDTO from(MealKitInfoAndStoreIdAndMonthlyTotalRevenueProjection projection) {
        return new MealKitInfoAndStoreIdAndMonthlyTotalRevenueProjectionDTO(
                projection.getMealKitId(),
                projection.getMealKitName(),
                projection.getMealKitClassification(),
                projection.getMealKitFoodClassification(),
                projection.getStoreId(),
                projection.getMealKitPrice(),
                projection.getMonthlyTotalRevenue()
        );
    }
}
