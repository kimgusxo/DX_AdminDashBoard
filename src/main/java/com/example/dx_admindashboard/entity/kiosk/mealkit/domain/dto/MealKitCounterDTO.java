package com.example.dx_admindashboard.entity.kiosk.mealkit.domain.dto;

import com.example.dx_admindashboard.entity.kiosk.mealkit.domain.MealKitCounter;
import com.example.dx_admindashboard.entity.kiosk.mealkit.domain.MealKit;
import com.example.dx_admindashboard.entity.store.domain.Store;

public record MealKitCounterDTO(
        Long storeId,
        Long mealKitId,
        Integer mealKitCount
) {
    public static MealKitCounterDTO of(Long storeId, Long mealKitId, Integer mealKitCount) {
        return new MealKitCounterDTO(storeId, mealKitId, mealKitCount);
    }

    public static MealKitCounterDTO from(MealKitCounter mealKitCounter) {
        return new MealKitCounterDTO(
                mealKitCounter.getStore().getStoreId(), // Store의 ID 추출
                mealKitCounter.getMealKit().getMealKitId(), // MealKit의 ID 추출
                mealKitCounter.getMealKitCount()
        );
    }

    public MealKitCounter toEntity() {
        return MealKitCounter.builder()
                .store(Store.builder().storeId(storeId).build()) // ID로 Store 엔티티 생성
                .mealKit(MealKit.builder().mealKitId(mealKitId).build()) // ID로 MealKit 엔티티 생성
                .mealKitCount(mealKitCount)
                .build();
    }
}
