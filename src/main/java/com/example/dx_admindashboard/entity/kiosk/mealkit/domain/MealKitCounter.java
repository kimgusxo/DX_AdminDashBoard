package com.example.dx_admindashboard.entity.kiosk.mealkit.domain;

import com.example.dx_admindashboard.entity.store.domain.Store;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "MEAL_KIT_COUNTER_TB")
public class MealKitCounter {

    @Id
    @GeneratedValue
    @Column(name = "MEAL_KIT_COUNTER_ID")
    private Long mealKitCounterId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEAL_KIT_ID")
    private MealKit mealKit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STORE_ID")
    private Store store;

    @NotNull
    @Column(name = "MEAL_KIT_COUNT")
    private Integer mealKitCount;

}
