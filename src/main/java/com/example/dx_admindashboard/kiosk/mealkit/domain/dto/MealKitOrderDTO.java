package com.example.dx_admindashboard.kiosk.mealkit.domain.dto;

import com.example.dx_admindashboard.kiosk.mealkit.domain.MealKitOrder;

public record MealKitOrderDTO(
        Long mealKitOrderId,
        Long mealKitId,
        Long orderId
) {
    public static MealKitOrderDTO of(Long mealKitOrderId,
                                     Long mealKitId,
                                     Long orderId) {
        return new MealKitOrderDTO(mealKitOrderId, mealKitId, orderId);
    }

    public static MealKitOrderDTO from(MealKitOrder mealKitOrder) {
        return new MealKitOrderDTO(
                mealKitOrder.getMealKitOrderId(),
                mealKitOrder.getMealKitId(),
                mealKitOrder.getOrderId()
        );
    }

    public MealKitOrder toEntity() {
        return MealKitOrder.builder()
                .storeId(mealKitOrderId)
                .mealKitId(mealKitId)
                .mealKitCount(orderId)
                .build();
    }
}