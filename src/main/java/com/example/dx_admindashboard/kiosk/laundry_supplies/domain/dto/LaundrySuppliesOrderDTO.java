package com.example.dx_admindashboard.kiosk.laundry_supplies.domain.dto;

import com.example.dx_admindashboard.kiosk.laundry_supplies.domain.LaundrySuppliesOrder;
import com.example.dx_admindashboard.kiosk.laundry_supplies.domain.LaundrySupplies;
import com.example.dx_admindashboard.order.domain.Order;

public record LaundrySuppliesOrderDTO(
        Long laundrySuppliesId,
        Long orderId
) {
    public static LaundrySuppliesOrderDTO of(Long laundrySuppliesId, Long orderId) {
        return new LaundrySuppliesOrderDTO(laundrySuppliesId, orderId);
    }

    public static LaundrySuppliesOrderDTO from(LaundrySuppliesOrder laundrySuppliesOrder) {
        return new LaundrySuppliesOrderDTO(
                laundrySuppliesOrder.getLaundrySupplies().getLaundrySuppliesId(), // 엔티티의 ID 추출
                laundrySuppliesOrder.getOrder().getOrderId() // 엔티티의 ID 추출
        );
    }

    public LaundrySuppliesOrder toEntity() {
        return LaundrySuppliesOrder.builder()
                .laundrySupplies(LaundrySupplies.builder().laundrySuppliesId(laundrySuppliesId).build()) // ID로 엔티티 생성
                .order(Order.builder().orderId(orderId).build()) // ID로 엔티티 생성
                .build();
    }
}
