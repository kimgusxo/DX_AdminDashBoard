package com.example.dx_admindashboard.home_appliances.domain;

import com.example.dx_admindashboard.order.domain.Order;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "HOME_APPLIANCES_USED_TB")
public class HomeAppliancesUsed {

    @Id
    @GeneratedValue
    @Column(name = "HOME_APPLIANCES_USED_ID")
    private int homeAppliancesUsedId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "HOME_APPLIANCES_ID")
    private HomeAppliances homeAppliances;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID")
    private Order order;
}
