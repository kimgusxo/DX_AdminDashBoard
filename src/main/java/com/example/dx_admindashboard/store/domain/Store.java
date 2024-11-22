package com.example.dx_admindashboard.store.domain;

import com.example.dx_admindashboard.home_appliances.domain.HomeAppliancesState;
import com.example.dx_admindashboard.kiosk.laundry_supplies.domain.LaundrySuppliesCounter;
import com.example.dx_admindashboard.kiosk.mealkit.domain.MealKitCounter;
import com.example.dx_admindashboard.order.domain.Order;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "STORE_TB")
public class Store {

    @Id
    @GeneratedValue
    @Column(name = "STORE_ID")
    private Long storeId;

    @NotNull
    @Column(name = "STORE_NAME")
    private String storeName;

    @NotNull
    @Column(name = "STORE_ADDRESS")
    private String storeAddress;

    @NotNull
    @Column(name = "LATITUDE")
    private Double latitude;

    @NotNull
    @Column(name = "LONGITUDE")
    private Double longitude;

    @OneToMany(mappedBy = "store")
    private List<Order> orderList;

    @OneToMany(mappedBy = "store")
    private List<LaundrySuppliesCounter> supplierList;

    @OneToMany(mappedBy = "store")
    private List<HomeAppliancesState> homeAppliancesStateList;

    @OneToMany(mappedBy = "store")
    private List<MealKitCounter> mealKitCounterList;

}
