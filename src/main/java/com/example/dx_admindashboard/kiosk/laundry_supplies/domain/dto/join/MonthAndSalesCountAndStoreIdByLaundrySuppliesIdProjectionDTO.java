package com.example.dx_admindashboard.kiosk.laundry_supplies.domain.dto.join;

import com.example.dx_admindashboard.kiosk.laundry_supplies.domain.projection.MonthAndSalesCountAndStoreIdByLaundrySuppliesIdProjection;

public record MonthAndSalesCountAndStoreIdByLaundrySuppliesIdProjectionDTO(
        Integer month,
        Long salesCount,
        Long storeId
) {
    public static MonthAndSalesCountAndStoreIdByLaundrySuppliesIdProjectionDTO from(MonthAndSalesCountAndStoreIdByLaundrySuppliesIdProjection projection) {
        return new MonthAndSalesCountAndStoreIdByLaundrySuppliesIdProjectionDTO(
                projection.getMonth(),
                projection.getSalesCount(),
                projection.getStoreId()
        );
    }
}
