package com.example.dx_admindashboard.kiosk.laundry_supplies.domain.dto;

import com.example.dx_admindashboard.kiosk.laundry_supplies.domain.LaundrySupplies;
import com.example.dx_admindashboard.kiosk.laundry_supplies.domain.LaundrySuppliesCounter;
import com.example.dx_admindashboard.store.domain.Store;

public record LaundrySuppliesCounterDTO(
        Long laundrySuppliesCounterId,
        Long laundrySuppliesId,
        Long storeId,
        Integer laundrySuppliesCount
) {
    public static LaundrySuppliesCounterDTO of(Long laundrySuppliesCounterId,
                                               Long laundrySuppliesId,
                                               Long storeId,
                                               Integer laundrySuppliesCount) {
        return new LaundrySuppliesCounterDTO(laundrySuppliesCounterId, laundrySuppliesId, storeId, laundrySuppliesCount);
    }

    public static LaundrySuppliesCounterDTO from(LaundrySuppliesCounter laundrySuppliesCounter) {
        return new LaundrySuppliesCounterDTO(
                laundrySuppliesCounter.getLaundrySuppliesCounterId(),
                laundrySuppliesCounter.getLaundrySupplies().getLaundrySuppliesId(), // LaundrySupplies 엔티티의 ID 가져오기
                laundrySuppliesCounter.getStore().getStoreId(),
                Integer.parseInt(laundrySuppliesCounter.getLaundrySuppliesCount()) // String을 Integer로 변환
        );
    }

    public LaundrySuppliesCounter toEntity() {
        return LaundrySuppliesCounter.builder()
                .laundrySuppliesCounterId(laundrySuppliesCounterId)
                .laundrySupplies(LaundrySupplies.builder().laundrySuppliesId(laundrySuppliesId).build())
                .store(Store.builder().storeId(storeId).build())
                .laundrySuppliesCount(String.valueOf(laundrySuppliesCount)) // Integer를 String으로 변환
                .build();
    }
}
