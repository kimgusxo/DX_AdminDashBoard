package com.example.dx_admindashboard.order.domain.projection;

public interface OrderMonthlySalesRevenueAndStoreIdProjection {
    Integer getMonth();
    Long getTotalRevenue();
    Long getStoreId();
}
