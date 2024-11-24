package com.example.dx_admindashboard.entity.kiosk.laundry_supplies.domain;

import com.example.dx_admindashboard.entity.order.domain.Order;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "LAUNDRY_SUPPLIES_ORDER_TB")
public class LaundrySuppliesOrder {

    @Id
    @GeneratedValue
    @Column(name = "LAUNDRY_SUPPLIES_ORDER_ID")
    private Long laundrySuppliesOrderId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LAUNDRY_SUPPLIES_ID")
    private LaundrySupplies laundrySupplies;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID")
    private Order order;

}
