package com.example.dx_admindashboard.kiosk.laundry_ticket.domain;

import com.example.dx_admindashboard.order.domain.Order;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "LAUNDRY_TICKET_ORDER_TB")
public class LaundryTicketOrder {

    @Id
    @GeneratedValue
    @Column(name = "LAUNDRY_TICKET_ORDER_ID")
    private Long laundryTicketOrderId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LAUNDRY_TICKET_ID")
    private LaundryTicket laundryTicket;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID")
    private Order order;

}
