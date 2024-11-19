package com.example.dx_admindashboard.kiosk.mealkit.domain;

import com.example.dx_admindashboard.order.domain.Order;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "MEAL_KIT_ORDER_TB")
public class MealKitOrder {

    @Id
    @GeneratedValue
    @Column(name = "MEAL_KIT_ORDER_ID")
    private Long mealKitOrderId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEAL_KIT_ID")
    private MealKit mealKit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID")
    private Order order;

}
