package com.example.dx_admindashboard.entity.kiosk.mealkit.domain.dto;

import com.example.dx_admindashboard.entity.kiosk.mealkit.domain.MealKitOrder;
import com.example.dx_admindashboard.entity.kiosk.mealkit.domain.MealKit;
import com.example.dx_admindashboard.entity.order.domain.Order;

public record MealKitOrderDTO(
        Long mealKitOrderId,
        Long mealKitId,
        Long orderId
) {
    public static MealKitOrderDTO of(Long mealKitOrderId, Long mealKitId, Long orderId) {
        return new MealKitOrderDTO(mealKitOrderId, mealKitId, orderId);
    }

    public static MealKitOrderDTO from(MealKitOrder mealKitOrder) {
        return new MealKitOrderDTO(
                mealKitOrder.getMealKitOrderId(),
                mealKitOrder.getMealKit().getMealKitId(), // MealKit의 ID 추출
                mealKitOrder.getOrder().getOrderId() // Order의 ID 추출
        );
    }

    public MealKitOrder toEntity() {
        return MealKitOrder.builder()
                .mealKitOrderId(mealKitOrderId)
                .mealKit(MealKit.builder().mealKitId(mealKitId).build()) // ID로 MealKit 엔티티 생성
                .order(Order.builder().orderId(orderId).build()) // ID로 Order 엔티티 생성
                .build();
    }
}
