package com.example.dx_admindashboard.home_appliances.domain.dto;

import com.example.dx_admindashboard.home_appliances.domain.HomeAppliancesState;

public record HomeAppliancesStateDTO(
        Long storeId,
        Long homeAppliancesId,
        String homeAppliancesState,
        String homeAppliancesPosition
) {
    public static HomeAppliancesStateDTO of(Long storeId,
                                            Long homeAppliancesId,
                                            String homeAppliancesState,
                                            String homeAppliancesPosition) {
        return new HomeAppliancesStateDTO(storeId, homeAppliancesId, homeAppliancesState, homeAppliancesPosition);
    }

    public static HomeAppliancesStateDTO from(HomeAppliancesState homeAppliancesState) {
        return new HomeAppliancesStateDTO(
                homeAppliancesState.getStore().getStoreId(),
                homeAppliancesState.getHomeAppliances().getHomeAppliancesId(),
                homeAppliancesState.getHomeAppliancesState(),
                homeAppliancesState.getHomeAppliancesPosition()
        );
    }

    public HomeAppliancesState toEntity() {
        return HomeAppliancesState.builder()
                .storeId(storeId)
                .homeAppliancesId(homeAppliancesId)
                .homeAppliancesState(homeAppliancesState)
                .homeAppliancesPosition(homeAppliancesPosition)
                .build();
    }
}
