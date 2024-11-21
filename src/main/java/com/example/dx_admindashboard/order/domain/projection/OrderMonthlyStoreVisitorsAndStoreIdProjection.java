package com.example.dx_admindashboard.order.domain.projection;

public interface OrderMonthlyStoreVisitorsAndStoreIdProjection {
    Integer getMonth();
    Long getVisitorCount();
    Long getStoreId();
}