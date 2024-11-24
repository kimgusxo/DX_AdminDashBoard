package com.example.dx_admindashboard.entity.home_appliances.domain.dto;

import com.example.dx_admindashboard.entity.home_appliances.domain.HomeAppliances;

public record HomeAppliancesDTO(
        Long homeAppliancesId,
        String homeAppliancesClassification,
        String homeAppliancesName,
        String homeAppliancesModelName,
        Integer homeAppliancesPrice,
        String homeAppliancesDescription
) {
    public static HomeAppliancesDTO of(Long homeAppliancesId,
                                       String homeAppliancesClassification,
                                       String homeAppliancesName,
                                       String homeAppliancesModelName,
                                       Integer homeAppliancesPrice,
                                       String homeAppliancesDescription) {
        return new HomeAppliancesDTO(homeAppliancesId, homeAppliancesClassification, homeAppliancesName, homeAppliancesModelName, homeAppliancesPrice, homeAppliancesDescription);
    }

    public static HomeAppliancesDTO from(HomeAppliances homeAppliances) {
        return new HomeAppliancesDTO(
                homeAppliances.getHomeAppliancesId(),
                homeAppliances.getHomeAppliancesClassification(),
                homeAppliances.getHomeAppliancesName(),
                homeAppliances.getHomeAppliancesModelName(),
                homeAppliances.getHomeAppliancesPrice(),
                homeAppliances.getHomeAppliancesDescription()
        );
    }

    public HomeAppliances toEntity() {
        return HomeAppliances.builder()
                .homeAppliancesId(homeAppliancesId)
                .homeAppliancesClassification(homeAppliancesClassification)
                .homeAppliancesName(homeAppliancesName)
                .homeAppliancesModelName(homeAppliancesModelName)
                .homeAppliancesPrice(homeAppliancesPrice)
                .homeAppliancesDescription(homeAppliancesDescription)
                .build();
    }
}
