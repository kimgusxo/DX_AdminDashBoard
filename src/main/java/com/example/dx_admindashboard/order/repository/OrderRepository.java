package com.example.dx_admindashboard.order.repository;

import com.example.dx_admindashboard.order.domain.Order;
import com.example.dx_admindashboard.order.domain.projection.OrderMonthlySalesRevenueProjection;
import com.example.dx_admindashboard.order.domain.projection.OrderMonthlyStoreVisitorsProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    // Main 페이지 1번
    List<Order> findAll();
    Order findByOrderId(Long orderId);

    // Main 페이지 2번은 통신 X

    // Main 페이지 3번
    @Query("""
            SELECT FUNCTION('MONTH', o.orderTime) AS month,
                   SUM(o.orderTotalPrice) AS totalRevenue
            FROM Order o
            WHERE FUNCTION('YEAR', o.orderTime) = :year
            GROUP BY FUNCTION('MONTH', o.orderTime)
            ORDER BY FUNCTION('MONTH', o.orderTime)
            """)
    List<OrderMonthlySalesRevenueProjection> findMonthlySalesRevenueByYear(int year);

    // Main 페이지 4번
    @Query("""
            SELECT FUNCTION('MONTH', o.orderTime) AS month,
                   COUNT(DISTINCT o.user.userId) AS visitorCount
            FROM Order o
            WHERE o.store.storeId = :storeId
            AND FUNCTION('YEAR', o.orderTime) = :year
            GROUP BY FUNCTION('MONTH', o.orderTime)
            ORDER BY FUNCTION('MONTH', o.orderTime)
            """)
    List<OrderMonthlyStoreVisitorsProjection> findMonthlyVisitorCountByStoreIdAndYear(Long storeId, int year);


}
