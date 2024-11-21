package com.example.dx_admindashboard.kiosk.mealkit.domain.projection;

public interface MealKitMonthlySalesAndStoreIdProjection {
    Integer getMonth();
    Long getSalesCount();
    Long getStoreId();
}
