package com.example.dx_admindashboard.entity.kiosk.laundry_ticket.domain.dto;

import com.example.dx_admindashboard.entity.kiosk.laundry_ticket.domain.LaundryTicket;

public record LaundryTicketDTO(
        Long laundryTicketId,
        String laundryTicketClassification,
        Integer laundryTicketPrice
) {
    public static LaundryTicketDTO of(Long laundryTicketId,
                                      String laundryTicketClassification,
                                      Integer laundryTicketPrice) {
        return new LaundryTicketDTO(laundryTicketId, laundryTicketClassification, laundryTicketPrice);
    }

    public static LaundryTicketDTO from(LaundryTicket laundryTicket) {
        return new LaundryTicketDTO(
                laundryTicket.getLaundryTicketId(),
                laundryTicket.getLaundryTicketClassification(),
                laundryTicket.getLaundryTicketPrice()
        );
    }

    public LaundryTicket toEntity() {
        return LaundryTicket.builder()
                .laundryTicketId(laundryTicketId)
                .laundryTicketClassification(laundryTicketClassification)
                .laundryTicketPrice(laundryTicketPrice)
                .build();
    }
}