package com.example.dx_admindashboard.entity.kiosk.laundry_ticket.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "LAUNDRY_TICKET_TB")
public class LaundryTicket {

    @Id
    @GeneratedValue
    @Column(name = "LAUNDRY_TICKET_ID")
    private Long laundryTicketId;

    @NotNull
    @Column(name = "LAUNDRY_TICKET_CLASSIFICATION")
    private String laundryTicketClassification;

    @NotNull
    @Column(name = "LAUNDRY_TICKET_PRICE")
    private Integer laundryTicketPrice;

    @OneToMany(mappedBy = "laundryTicket")
    private List<LaundryTicketOrder> laundryTicketOrderList;
}
