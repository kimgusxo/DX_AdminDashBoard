package com.example.dx_admindashboard.order.domain.projection;

public interface OrderMonthlySalesRevenueProjection {
    Integer getMonth();
    Long getTotalRevenue();
}
