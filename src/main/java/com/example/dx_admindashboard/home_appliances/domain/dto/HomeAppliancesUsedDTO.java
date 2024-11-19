package com.example.dx_admindashboard.home_appliances.domain.dto;

import com.example.dx_admindashboard.home_appliances.domain.HomeAppliances;
import com.example.dx_admindashboard.home_appliances.domain.HomeAppliancesUsed;
import com.example.dx_admindashboard.order.domain.Order;

public record HomeAppliancesUsedDTO(
        Long homeAppliancesId,
        Long orderId
) {
    public static HomeAppliancesUsedDTO of(Long homeAppliancesId,
                                          Long orderId) {
        return new HomeAppliancesUsedDTO(homeAppliancesId, orderId);
    }

    public static HomeAppliancesUsedDTO from(HomeAppliancesUsed homeApplianceUsed) {
        return new HomeAppliancesUsedDTO(
                homeApplianceUsed.getHomeAppliances().getHomeAppliancesId(),
                homeApplianceUsed.getOrder().getOrderId()
        );
    }

    public HomeAppliancesUsed toEntity() {
        return HomeAppliancesUsed.builder()
                .homeAppliances(new HomeAppliances(homeAppliancesId)) // 엔터티 생성자나 빌더를 통해 설정
                .order(new Order(orderId)) // 엔터티 생성자나 빌더를 통해 설정
                .build();
    }
}
