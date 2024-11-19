package com.example.dx_admindashboard.kiosk.mealkit.domain.dto;

import com.example.dx_admindashboard.kiosk.mealkit.domain.MealKit;

public record MealKitDTO(
        Long mealKitId,
        String mealKitClassification,
        String mealKitName,
        Integer mealKitPrice,
        String mealKitFoodClassification,
        String mealKitCompanyName,
        String mealKitDescription,
        String mealKitUrl
) {
    public static MealKitDTO of(Long mealKitId,
                                String mealKitClassification,
                                String mealKitName,
                                Integer mealKitPrice,
                                String mealKitFoodClassification,
                                String mealKitCompanyName,
                                String mealKitDescription,
                                String mealKitUrl) {
        return new MealKitDTO(mealKitId, mealKitClassification, mealKitName, mealKitPrice, mealKitFoodClassification, mealKitCompanyName, mealKitDescription, mealKitUrl);
    }

    public static MealKitDTO from(MealKit mealKit) {
        return new MealKitDTO(
                mealKit.getMealKitId(),
                mealKit.getMealKitClassification(),
                mealKit.getMealKitName(),
                mealKit.getMealKitPrice(),
                mealKit.getMealKitFoodClassification(),
                mealKit.getMealKitCompanyName(),
                mealKit.getMealKitDescription(),
                mealKit.getMealKitUrl()
        );
    }

    public MealKit toEntity() {
        return MealKit.builder()
                .mealKitId(mealKitId)
                .mealKitClassification(mealKitClassification)
                .mealKitName(mealKitName)
                .mealKitPrice(mealKitPrice)
                .mealKitFoodClassification(mealKitFoodClassification)
                .mealKitCompanyName(mealKitCompanyName)
                .mealKitDescription(mealKitDescription)
                .mealKitUrl(mealKitUrl)
                .build();
    }
}