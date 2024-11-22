package com.example.dx_admindashboard.kiosk.mealkit.domain;

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
@Table(name = "MEAL_KIT_TB")
public class MealKit {

    @Id
    @GeneratedValue
    @Column(name = "MEAL_KIT_ID")
    private Long mealKitId;

    @NotNull
    @Column(name = "MEAL_KIT_CLASSIFICATION")
    private String mealKitClassification;

    @NotNull
    @Column(name = "MEAL_KIT_NAME")
    private String mealKitName;

    @NotNull
    @Column(name = "MEAL_KIT_PRICE")
    private Integer mealKitPrice;

    @NotNull
    @Column(name = "MEAL_KIT_FOOD_CLASSIFICATION")
    private String mealKitFoodClassification;

    @NotNull
    @Column(name = "MEAL_KIT_COMPANY_NAME")
    private String mealKitCompanyName;

    @NotNull
    @Column(name = "MEAL_KIT_DESCRIPTION")
    private String mealKitDescription;

    @NotNull
    @Column(name = "MEAL_KIT_URL")
    private String mealKitUrl;

    @OneToMany(mappedBy = "mealKit")
    private List<MealKitCounter> mealKitCounterList;

    @OneToMany(mappedBy = "mealKit")
    private List<MealKitOrder> mealKitOrderList;
}
