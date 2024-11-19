package com.example.dx_admindashboard.kiosk.mealkit.domain.dto;

import com.example.dx_admindashboard.kiosk.mealkit.domain.MealKitCounter;

public record MealKitCounterDTO(
        Long storeId,
        Long mealKitId,
        Integer mealKitCount
) {
    public static MealKitCounterDTO of(Long storeId,
                                       Long mealKitId,
                                       Integer mealKitCount) {
        return new MealKitCounterDTO(storeId, mealKitId, mealKitCount);
    }

    public static MealKitCounterDTO from(MealKitCounter mealKitCounter) {
        return new MealKitCounterDTO(
                mealKitCounter.getStoreId(),
                mealKitCounter.getMealKitId(),
                mealKitCounter.getMealKitCount()
        );
    }

    public MealKitCounter toEntity() {
        return MealKitCounter.builder()
                .storeId(storeId)
                .mealKitId(mealKitId)
                .mealKitCount(mealKitCount)
                .build();
    }
}