package com.example.dx_admindashboard.home_appliances.domain.dto.join;

import com.example.dx_admindashboard.home_appliances.domain.projection.HomeAppliancesInfoAndStoreIdProjection;

public record HomeAppliancesInfoAndStoreIdProjectionDTO(
        Long homeAppliancesId,
        String homeAppliancesClassification,
        String homeAppliancesName,
        String homeAppliancesModelName,
        Long storeId
) {
    public static HomeAppliancesInfoAndStoreIdProjectionDTO from(HomeAppliancesInfoAndStoreIdProjection projection) {
        return new HomeAppliancesInfoAndStoreIdProjectionDTO(
                projection.getHomeAppliancesId(),
                projection.getHomeAppliancesClassification(),
                projection.getHomeAppliancesName(),
                projection.getHomeAppliancesModelName(),
                projection.getStoreId()
        );
    }
}
