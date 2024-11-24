package com.example.dx_admindashboard.entity.kiosk.laundry_supplies.domain;

import com.example.dx_admindashboard.entity.store.domain.Store;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "LAUNDRY_SUPPLIES_COUNTER_TB")
public class LaundrySuppliesCounter {

    @Id
    @GeneratedValue
    @Column(name = "LAUNDRY_SUPPLIES_COUNTER_ID")
    private Long laundrySuppliesCounterId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LAUNDRY_SUPPLIES_ID")
    private LaundrySupplies laundrySupplies;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STORE_ID")
    private Store store;

    @NotNull
    @Column(name = "LAUNDRY_SUPPLIES_COUNT")
    private String laundrySuppliesCount;


}
