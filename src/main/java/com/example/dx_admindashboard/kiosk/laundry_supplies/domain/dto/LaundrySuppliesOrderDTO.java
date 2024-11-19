package com.example.dx_admindashboard.kiosk.laundry_supplies.domain.dto;

import com.example.dx_admindashboard.kiosk.laundry_supplies.domain.LaundrySuppliesOrder;

public record LaundrySuppliesOrderDTO(
        Long laundryId,
        Long orderId
) {
    public static LaundrySuppliesOrderDTO of(Long laundryId,
                                             Long orderId) {
        return new LaundrySuppliesOrderDTO(laundryId, orderId);
    }
    public static LaundrySuppliesOrderDTO from(LaundrySuppliesOrder laundrySuppliesOrder) {
        return new LaundrySuppliesOrderDTO(
                laundrySuppliesOrder.getLaundryId(),
                laundrySuppliesOrder.getOrderId()
        );
    }
    public LaundrySuppliesOrder toEntity() {
        return LaundrySuppliesOrder.builder()
                .laundryId(laundryId)
                .orderId(orderId)
                .build();
    }
}