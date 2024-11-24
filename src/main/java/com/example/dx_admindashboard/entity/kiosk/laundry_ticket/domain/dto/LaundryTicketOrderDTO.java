package com.example.dx_admindashboard.entity.kiosk.laundry_ticket.domain.dto;

import com.example.dx_admindashboard.entity.kiosk.laundry_ticket.domain.LaundryTicketOrder;
import com.example.dx_admindashboard.entity.kiosk.laundry_ticket.domain.LaundryTicket;
import com.example.dx_admindashboard.entity.order.domain.Order;

public record LaundryTicketOrderDTO(
        Long laundryTicketOrderId,
        Long laundryTicketId,
        Long orderId
) {
    public static LaundryTicketOrderDTO of(Long laundryTicketOrderId, Long laundryTicketId, Long orderId) {
        return new LaundryTicketOrderDTO(laundryTicketOrderId, laundryTicketId, orderId);
    }

    public static LaundryTicketOrderDTO from(LaundryTicketOrder laundryTicketOrder) {
        return new LaundryTicketOrderDTO(
                laundryTicketOrder.getLaundryTicketOrderId(),
                laundryTicketOrder.getLaundryTicket().getLaundryTicketId(), // LaundryTicket의 ID 추출
                laundryTicketOrder.getOrder().getOrderId() // Order의 ID 추출
        );
    }

    public LaundryTicketOrder toEntity() {
        return LaundryTicketOrder.builder()
                .laundryTicketOrderId(laundryTicketOrderId)
                .laundryTicket(LaundryTicket.builder().laundryTicketId(laundryTicketId).build()) // ID로 엔티티 생성
                .order(Order.builder().orderId(orderId).build()) // ID로 엔티티 생성
                .build();
    }
}
