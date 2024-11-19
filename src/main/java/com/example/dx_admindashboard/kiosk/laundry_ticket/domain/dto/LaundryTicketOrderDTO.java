package com.example.dx_admindashboard.kiosk.laundry_ticket.domain.dto;

import com.example.dx_admindashboard.kiosk.laundry_ticket.domain.LaundryTicketOrder;

public record LaundryTicketOrderDTO(
        Long laundryTicketOrderId,
        Long laundryTicketId,
        Long orderId
) {
    public static LaundryTicketOrderDTO of(Long laundryTicketOrderId,
                                           Long laundryTicketId,
                                           Long orderId) {
        return new LaundryTicketOrderDTO(laundryTicketOrderId, laundryTicketId, orderId);
    }

    public static LaundryTicketOrderDTO from(LaundryTicketOrder laundryTicketOrder) {
        return new LaundryTicketOrderDTO(
                laundryTicketOrder.getLaundryTicketOrderId(),
                laundryTicketOrder.getLaundryTicketId(),
                laundryTicketOrder.getOrderId()
        );
    }

    public LaundryTicketOrder toEntity() {
        return LaundryTicketOrder.builder()
                .laundryTicketOrderId(laundryTicketOrderId)
                .laundryTicketId(laundryTicketId)
                .orderId(orderId)
                .build();
    }
}