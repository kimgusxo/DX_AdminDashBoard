package com.example.dx_admindashboard.entity.kiosk.laundry_supplies.domain.dto.join;

import com.example.dx_admindashboard.entity.kiosk.laundry_supplies.domain.projection.LaundrySuppliesInfoAndStoreIdAndStoreCountProjection;

public record LaundrySuppliesInfoAndStoreIdAndStoreCountProjectionDTO(
        Long laundrySuppliesId,
        String laundrySuppliesName,
        String laundrySuppliesClassification,
        Integer laundrySuppliesPrice,
        Long storeId,
        Integer storeCount
) {
    public static LaundrySuppliesInfoAndStoreIdAndStoreCountProjectionDTO from(LaundrySuppliesInfoAndStoreIdAndStoreCountProjection projection) {
        return new LaundrySuppliesInfoAndStoreIdAndStoreCountProjectionDTO(
                projection.getLaundrySuppliesId(),
                projection.getLaundrySuppliesName(),
                projection.getLaundrySuppliesClassification(),
                projection.getLaundrySuppliesPrice(),
                projection.getStoreId(),
                projection.getStoreCount()
        );
    }
}
