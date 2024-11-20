package com.example.dx_admindashboard.store.domain.dto;

import com.example.dx_admindashboard.store.domain.Store;

public record StoreDTO(
        Long storeId,
        String storeName,
        String storeAddress,
        Double latitude,
        Double longitude
) {
    public static StoreDTO of(Long storeId, String storeName, String storeAddress, Double latitude, Double longitude) {
        return new StoreDTO(storeId, storeName, storeAddress, latitude, longitude);
    }

    public static StoreDTO from(Store store) {
        return new StoreDTO(
                store.getStoreId(),
                store.getStoreName(),
                store.getStoreAddress(),
                store.getLatitude(),
                store.getLongitude()
        );
    }

    public Store toEntity() {
        return Store.builder()
                .storeId(storeId)
                .storeName(storeName)
                .storeAddress(storeAddress)
                .latitude(latitude)
                .longitude(longitude)
                .build();
    }
}
