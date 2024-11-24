package com.example.dx_admindashboard.entity.order.domain.dto.join;

import com.example.dx_admindashboard.entity.order.domain.projection.MonthAndVisitorCountAndStoreIdByYearProjection;

public record MonthAndVisitorCountAndStoreIdByYearProjectionDTO(
        Integer month,
        Long visitorCount,
        Long storeId
) {
    public static MonthAndVisitorCountAndStoreIdByYearProjectionDTO from(MonthAndVisitorCountAndStoreIdByYearProjection projection) {
        return new MonthAndVisitorCountAndStoreIdByYearProjectionDTO(
                projection.getMonth(),
                projection.getVisitorCount(),
                projection.getStoreId()
        );
    }
}
