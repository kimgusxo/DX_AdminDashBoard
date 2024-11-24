package com.example.dx_admindashboard.entity.kiosk.mealkit.domain.dto.join;

import com.example.dx_admindashboard.entity.kiosk.mealkit.domain.projection.MonthAndSalesCountAndStoreIdByMealKitIdAndYearProjection;

public record MonthAndSalesCountAndStoreIdByMealKitIdAndYearProjectionDTO(
        Integer month,
        Long salesCount,
        Long storeId
) {
    public static MonthAndSalesCountAndStoreIdByMealKitIdAndYearProjectionDTO from(MonthAndSalesCountAndStoreIdByMealKitIdAndYearProjection projection) {
        return new MonthAndSalesCountAndStoreIdByMealKitIdAndYearProjectionDTO(
                projection.getMonth(),
                projection.getSalesCount(),
                projection.getStoreId()
        );
    }
}
