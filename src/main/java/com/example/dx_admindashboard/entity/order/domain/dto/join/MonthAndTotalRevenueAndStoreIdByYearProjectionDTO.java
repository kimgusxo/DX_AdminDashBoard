package com.example.dx_admindashboard.entity.order.domain.dto.join;

import com.example.dx_admindashboard.entity.order.domain.projection.MonthAndTotalRevenueAndStoreIdByYearProjection;

public record MonthAndTotalRevenueAndStoreIdByYearProjectionDTO(
        Integer month,
        Long totalRevenue,
        Long storeId
) {
    public static MonthAndTotalRevenueAndStoreIdByYearProjectionDTO from(MonthAndTotalRevenueAndStoreIdByYearProjection projection) {
        return new MonthAndTotalRevenueAndStoreIdByYearProjectionDTO(
                projection.getMonth(),
                projection.getTotalRevenue(),
                projection.getStoreId()
        );
    }
}
