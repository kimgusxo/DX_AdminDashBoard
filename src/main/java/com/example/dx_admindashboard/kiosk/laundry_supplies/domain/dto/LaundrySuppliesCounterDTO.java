package com.example.dx_admindashboard.kiosk.laundry_supplies.domain.dto;

import com.example.dx_admindashboard.kiosk.laundry_supplies.domain.LaundrySuppliesCounter;

public record LaundrySuppliesCounterDTO(
        Long laundrySuppliesCounterId,
        Long laundryId,
        Long storeId,
        Integer laundrySuppliesCount
) {
    public static LaundrySuppliesCounterDTO of(Long laundrySuppliesCounterId,
                                               Long laundryId,
                                               Long storeId,
                                               Integer laundrySuppliesCount) {
        return new LaundrySuppliesCounterDTO(laundrySuppliesCounterId, laundryId, storeId, laundrySuppliesCount);
    }

    public static LaundrySuppliesCounterDTO from(LaundrySuppliesCounter laundrySuppliesCounter) {
        return new LaundrySuppliesCounterDTO(
                laundrySuppliesCounter.getLaundrySuppliesCounterId(),
                laundrySuppliesCounter.getLaundryId(),
                laundrySuppliesCounter.getStoreId(),
                laundrySuppliesCounter.getLaundrySuppliesCount()
        );
    }

    public LaundrySuppliesCounter toEntity() {
        return LaundrySuppliesCounter.builder()
                .laundrySuppliesCounterId(laundrySuppliesCounterId)
                .laundryId(laundryId)
                .storeId(storeId)
                .laundrySuppliesCount(laundrySuppliesCount)
                .build();
    }
}