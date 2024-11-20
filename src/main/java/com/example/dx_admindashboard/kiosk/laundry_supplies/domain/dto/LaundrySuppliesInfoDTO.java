package com.example.dx_admindashboard.kiosk.laundry_supplies.domain.dto;

import com.example.dx_admindashboard.kiosk.laundry_supplies.domain.projection.LaundrySuppliesInfoProjection;

public record LaundrySuppliesInfoDTO(
        Long laundrySuppliesId,
        String laundrySuppliesName,
        String laundrySuppliesClassification,
        Integer laundrySuppliesPrice,
        Long storeId,
        Integer storeCount
) {
    public static LaundrySuppliesInfoDTO from(LaundrySuppliesInfoProjection projection) {
        return new LaundrySuppliesInfoDTO(
                projection.getLaundrySuppliesId(),
                projection.getLaundrySuppliesName(),
                projection.getLaundrySuppliesClassification(),
                projection.getLaundrySuppliesPrice(),
                projection.getStoreId(),
                projection.getStoreCount()
        );
    }
}

