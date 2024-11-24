package com.example.dx_admindashboard.entity.kiosk.laundry_supplies.domain.dto.join;

import com.example.dx_admindashboard.entity.kiosk.laundry_supplies.domain.projection.LaundrySuppliesInfoAndStoreIdAndTotalSalesProjection;

public record LaundrySuppliesInfoAndStoreIdAndTotalSalesProjectionDTO(
        Long laundrySuppliesId,
        String laundrySuppliesName,
        String laundrySuppliesClassification,
        Integer laundrySuppliesPrice,
        Long storeId,
        Long totalSales
) {
    public static LaundrySuppliesInfoAndStoreIdAndTotalSalesProjectionDTO from(LaundrySuppliesInfoAndStoreIdAndTotalSalesProjection projection) {
        return new LaundrySuppliesInfoAndStoreIdAndTotalSalesProjectionDTO(
                projection.getLaundrySuppliesId(),
                projection.getLaundrySuppliesName(),
                projection.getLaundrySuppliesClassification(),
                projection.getLaundrySuppliesPrice(),
                projection.getStoreId(),
                projection.getTotalSales()
        );
    }
}
