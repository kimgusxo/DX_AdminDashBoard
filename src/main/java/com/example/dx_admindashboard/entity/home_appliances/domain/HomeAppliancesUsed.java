package com.example.dx_admindashboard.entity.home_appliances.domain;

import com.example.dx_admindashboard.entity.order.domain.Order;
import jakarta.persistence.*;
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
    private Long homeAppliancesUsedId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "HOME_APPLIANCES_ID")
    private HomeAppliances homeAppliances;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID")
    private Order order;
}
