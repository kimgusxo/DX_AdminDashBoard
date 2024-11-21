package com.example.dx_admindashboard.order.repository;

import com.example.dx_admindashboard.order.domain.Order;
import com.example.dx_admindashboard.order.domain.projection.MonthAndTotalRevenueAndStoreIdByYearProjection;
import com.example.dx_admindashboard.order.domain.projection.MonthAndVisitorCountAndStoreIdByYearProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    // Main 페이지 3번
    @Query("""
            SELECT FUNCTION('MONTH', o.orderTime) AS month,
                   SUM(o.orderTotalPrice) AS totalRevenue,
                   o.store.storeId AS storeId
            FROM Order o
            WHERE FUNCTION('YEAR', o.orderTime) = :year
            GROUP BY FUNCTION('MONTH', o.orderTime)
            ORDER BY FUNCTION('MONTH', o.orderTime)
            """)
    List<MonthAndTotalRevenueAndStoreIdByYearProjection> findTotalRevenueListByStoreIdAndYear(@Param("storeId") Long storeId,
                                                                                     @Param("year") Integer year);



    // Main 페이지 5번
    @Query("""
            SELECT FUNCTION('MONTH', o.orderTime) AS month,
                   COUNT(DISTINCT o.user.userId) AS visitorCount,
                   o.store.storeId AS storeId
            FROM Order o
            WHERE o.store.storeId = :storeId
            AND FUNCTION('YEAR', o.orderTime) = :year
            GROUP BY FUNCTION('MONTH', o.orderTime)
            ORDER BY FUNCTION('MONTH', o.orderTime)
            """)
    List<MonthAndVisitorCountAndStoreIdByYearProjection> findVisitorCountListByStoreIdAndYear(@Param("storeId") Long storeId,
                                                                                                @Param("year") Integer year);
}
