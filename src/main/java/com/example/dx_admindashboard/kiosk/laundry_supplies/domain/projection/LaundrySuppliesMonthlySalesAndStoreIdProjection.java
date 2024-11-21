package com.example.dx_admindashboard.kiosk.laundry_supplies.domain.projection;

public interface LaundrySuppliesMonthlySalesAndStoreIdProjection {
    Integer getMonth();
    Long getSalesCount();
    Long getStoreId();
}
