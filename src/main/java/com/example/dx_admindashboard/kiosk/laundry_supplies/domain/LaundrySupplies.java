package com.example.dx_admindashboard.kiosk.laundry_supplies.domain;

import com.example.dx_admindashboard.kiosk.laundry_ticket.domain.LaundryTicketOrder;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "LAUNDRY_SUPPLIES_TB")
public class LaundrySupplies {

    @Id
    @GeneratedValue
    @Column(name = "LAUNDRY_SUPPLIES_ID")
    private Long laundrySuppliesId;

    @NotNull
    @Column(name = "LAUNDRY_SUPPLIES_NAME")
    private String laundrySuppliesName;

    @NotNull
    @Column(name = "LAUNDRY_SUPPLIES_PRICE")
    private Integer laundrySuppliesPrice;

    @NotNull
    @Column(name = "LAUNDRY_SUPPLIES_CLASSIFICATION")
    private String laundrySuppliesClassification;

    @NotNull
    @Column(name = "LAUNDRY_SUPPLIES_COMPANY_NAME")
    private String laundrySuppliesCompanyName;

    @NotNull
    @Column(name = "LAUNDRY_SUPPLIES_DESCRIPTION")
    private String laundrySuppliesDescription;

    @NotNull
    @Column(name = "LAUNDRY_SUPPLIES_URL")
    private String laundrySuppliesUrl;

    @OneToMany(mappedBy = "laundrySuppliesCounter")
    private List<LaundrySuppliesCounter> laundrySuppliesCounterList;

    @OneToMany(mappedBy = "laundrySuppliesOrder")
    private List<LaundrySuppliesOrder> laundrySuppliesOrderList;

}
