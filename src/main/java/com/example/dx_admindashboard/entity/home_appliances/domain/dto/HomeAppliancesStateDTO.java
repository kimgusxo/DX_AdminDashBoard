package com.example.dx_admindashboard.entity.home_appliances.domain.dto;

import com.example.dx_admindashboard.entity.home_appliances.domain.HomeAppliances;
import com.example.dx_admindashboard.entity.home_appliances.domain.HomeAppliancesState;
import com.example.dx_admindashboard.entity.store.domain.Store;

public record HomeAppliancesStateDTO(
        Long storeId,
        Long homeAppliancesId,
        String homeAppliancesState,
        Integer homeAppliancesPosition
) {
    public static HomeAppliancesStateDTO of(Long storeId,
                                            Long homeAppliancesId,
                                            String homeAppliancesState,
                                            Integer homeAppliancesPosition) {
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
                .homeAppliances(HomeAppliances.builder().homeAppliancesId(homeAppliancesId).build())
                .store(Store.builder().storeId(storeId).build())
                .homeAppliancesState(homeAppliancesState)
                .homeAppliancesPosition(homeAppliancesPosition)
                .build();
    }
}
