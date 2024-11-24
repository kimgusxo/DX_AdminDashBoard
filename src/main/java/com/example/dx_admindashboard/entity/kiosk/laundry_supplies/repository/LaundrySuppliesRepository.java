package com.example.dx_admindashboard.entity.kiosk.laundry_supplies.repository;

import com.example.dx_admindashboard.entity.kiosk.laundry_supplies.domain.LaundrySupplies;

import com.example.dx_admindashboard.entity.kiosk.laundry_supplies.domain.projection.LaundrySuppliesInfoAndStoreIdAndStoreCountProjection;
import com.example.dx_admindashboard.entity.kiosk.laundry_supplies.domain.projection.LaundrySuppliesInfoAndStoreIdAndTotalSalesProjection;
import com.example.dx_admindashboard.entity.kiosk.laundry_supplies.domain.projection.MonthAndSalesCountAndStoreIdByLaundrySuppliesIdProjection;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LaundrySuppliesRepository extends JpaRepository<LaundrySupplies, Long> {

    // 세탁용품 재고 페이지 1번
    @Query("""
            SELECT ls.laundrySuppliesId AS laundrySuppliesId,
                   ls.laundrySuppliesName AS laundrySuppliesName,
                   ls.laundrySuppliesClassification AS laundrySuppliesClassification,
                   ls.laundrySuppliesPrice AS laundrySuppliesPrice,
                   lc.store.storeId AS storeId,
                   lc.laundrySuppliesCount AS storeCount
            FROM LaundrySupplies ls
            JOIN LaundrySuppliesCounter lc ON ls.laundrySuppliesId = lc.laundrySupplies.laundrySuppliesId
            WHERE lc.store.storeId = :storeId
           """)
    List<LaundrySuppliesInfoAndStoreIdAndStoreCountProjection> findLaundrySuppliesByStoreId(@Param("storeId") Long storeId);

    // 주문 페이지 2번 (재고 10개 미만 상품)
    @Query("""
            SELECT ls.laundrySuppliesId AS laundrySuppliesId,
                   ls.laundrySuppliesName AS laundrySuppliesName,
                   ls.laundrySuppliesClassification AS laundrySuppliesClassification,
                   ls.laundrySuppliesPrice AS laundrySuppliesPrice,
                   lc.store.storeId AS storeId,
                   lc.laundrySuppliesCount AS storeCount
            FROM LaundrySupplies ls
            JOIN LaundrySuppliesCounter lc ON ls.laundrySuppliesId = lc.laundrySupplies.laundrySuppliesId
            WHERE lc.store.storeId = :storeId
            AND lc.laundrySuppliesCount < :remainCount
           """)
    List<LaundrySuppliesInfoAndStoreIdAndStoreCountProjection> findLaundrySuppliesByStoreIdAndLaundrySuppliesCountLessThan10(@Param("storeId") Long storeId,
                                                                                                                             @Param("remainCount") Integer remainCount);

    // 세탁용품 재고 페이지 2번 (월별 판매량)
    @Query("""
            SELECT EXTRACT(MONTH FROM o.orderTime) AS month,
                   COUNT(lso) AS salesCount,
                   o.store.storeId AS storeId
            FROM LaundrySuppliesOrder lso
            JOIN lso.order o
            WHERE lso.laundrySupplies.laundrySuppliesId = :laundrySuppliesId
            AND o.store.storeId = :storeId
            AND EXTRACT(YEAR FROM o.orderTime) = :year
            GROUP BY EXTRACT(MONTH FROM o.orderTime), o.store.storeId
            ORDER BY EXTRACT(MONTH FROM o.orderTime)
            """)
    List<MonthAndSalesCountAndStoreIdByLaundrySuppliesIdProjection> findLaundrySuppliesSalesCountByLaundrySuppliesIdAndStoreIdAndYear(@Param("laundrySuppliesId") Long laundrySuppliesId,
                                                                                                                                      @Param("storeId") Long storeId,
                                                                                                                                      @Param("year") Integer year);

    // 세탁용품 재고 페이지 3번 (연도별)
    @Query("""
            SELECT ls.laundrySuppliesId AS laundrySuppliesId,
                   ls.laundrySuppliesName AS laundrySuppliesName,
                   ls.laundrySuppliesClassification AS laundrySuppliesClassification,
                   ls.laundrySuppliesPrice AS laundrySuppliesPrice,
                   o.store.storeId AS storeId,
                   COUNT(lso) AS totalSales
            FROM LaundrySupplies ls
            JOIN LaundrySuppliesOrder lso ON ls.laundrySuppliesId = lso.laundrySupplies.laundrySuppliesId
            JOIN lso.order o
            WHERE o.store.storeId = :storeId
            AND EXTRACT(YEAR FROM o.orderTime) = :year
            GROUP BY ls.laundrySuppliesId, o.store.storeId
            ORDER BY totalSales DESC
            """)
    List<LaundrySuppliesInfoAndStoreIdAndTotalSalesProjection> findLaundrySuppliesSalesCountTop5ByStoreIdAndYear(@Param("storeId") Long storeId,
                                                                                                                 @Param("year") Integer year,
                                                                                                                 Pageable pageable);

    // 세탁용품 재고 페이지 3번 (연도/월별)
    @Query("""
            SELECT ls.laundrySuppliesId AS laundrySuppliesId,
                   ls.laundrySuppliesName AS laundrySuppliesName,
                   ls.laundrySuppliesClassification AS laundrySuppliesClassification,
                   ls.laundrySuppliesPrice AS laundrySuppliesPrice,
                   o.store.storeId AS storeId,
                   COUNT(lso) AS totalSales
            FROM LaundrySupplies ls
            JOIN LaundrySuppliesOrder lso ON ls.laundrySuppliesId = lso.laundrySupplies.laundrySuppliesId
            JOIN lso.order o
            WHERE o.store.storeId = :storeId
            AND EXTRACT(YEAR FROM o.orderTime) = :year
            AND EXTRACT(MONTH FROM o.orderTime) = :month
            GROUP BY ls.laundrySuppliesId, o.store.storeId
            ORDER BY totalSales DESC
            """)
    List<LaundrySuppliesInfoAndStoreIdAndTotalSalesProjection> findLaundrySuppliesSalesCountTop5ByStoreIdAndYearAndMonth(@Param("storeId") Long storeId,
                                                                                                                         @Param("year") Integer year,
                                                                                                                         @Param("month") Integer month,
                                                                                                                         Pageable pageable);

}
