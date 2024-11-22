package com.example.dx_admindashboard.order.domain;

import com.example.dx_admindashboard.home_appliances.domain.HomeAppliancesUsed;
import com.example.dx_admindashboard.kiosk.laundry_supplies.domain.LaundrySuppliesOrder;
import com.example.dx_admindashboard.kiosk.laundry_ticket.domain.LaundryTicketOrder;
import com.example.dx_admindashboard.kiosk.mealkit.domain.MealKitOrder;
import com.example.dx_admindashboard.store.domain.Store;
import com.example.dx_admindashboard.user.domain.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "ORDER_TB")
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long orderId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STORE_ID")
    private Store store;

    @NotNull
    @Column(name = "SPACE_IS_USED")
    private Boolean spaceIsUsed;

    @NotNull
    @Column(name = "ORDER_TOTAL_PRICE")
    private Integer orderTotalPrice;

    @NotNull
    @Column(name = "ORDER_TIME")
    private LocalDateTime orderTime;

    @OneToMany(mappedBy = "order")
    private List<MealKitOrder> mealKitOrderList;

    @OneToMany(mappedBy = "order")
    private List<LaundryTicketOrder> laundryTicketOrderList;

    @OneToMany(mappedBy = "order")
    private List<LaundrySuppliesOrder> laundrySuppliesOrderList;

    @OneToMany(mappedBy = "order")
    private List<HomeAppliancesUsed> homeAppliancesUsedList;

}