package com.example.dx_admindashboard.kiosk.laundry_supplies.repository;

import com.example.dx_admindashboard.kiosk.laundry_supplies.domain.LaundrySupplies;

import com.example.dx_admindashboard.kiosk.laundry_supplies.domain.projection.LaundrySuppliesAndStoreIdAndStoreCountProjection;
import com.example.dx_admindashboard.kiosk.laundry_supplies.domain.projection.LaundrySuppliesAndStoreIdAndTotalSalesProjection;
import com.example.dx_admindashboard.kiosk.laundry_supplies.domain.projection.LaundrySuppliesMonthlySalesAndStoreIdProjection;
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
    List<LaundrySuppliesAndStoreIdAndStoreCountProjection> findStoreIdByLaundrySuppliesAndCountProjectionList(@Param("storeId") Long storeId);

    // 세탁용품 재고 페이지 2번 (월별 판매량)
    @Query("""
            SELECT FUNCTION('MONTH', o.orderTime) AS month,
                   COUNT(lso) AS salesCount,
                   o.store.storeId AS storeId
            FROM LaundrySuppliesOrder lso
            JOIN lso.order o
            WHERE lso.laundrySupplies.laundrySuppliesId = :laundrySuppliesId
            AND o.store.storeId = :storeId
            AND FUNCTION('YEAR', o.orderTime) = :year
            GROUP BY FUNCTION('MONTH', o.orderTime)
            ORDER BY FUNCTION('MONTH', o.orderTime)
            """)
    List<LaundrySuppliesMonthlySalesAndStoreIdProjection> findMonthlySalesForYearByLaundrySuppliesIdAndStoreId(@Param("laundrySuppliesId") Long laundrySuppliesId,
                                                                                                                          @Param("storeId") Long storeId,
                                                                                                                          @Param("year") int year);

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
            AND FUNCTION('YEAR', o.orderTime) = :year
            GROUP BY ls.laundrySuppliesId, ls.laundrySuppliesName, ls.laundrySuppliesClassification, ls.laundrySuppliesPrice, o.store.storeId
            ORDER BY totalSales DESC
            """)
    List<LaundrySuppliesAndStoreIdAndTotalSalesProjection> findTop5ByOrderCountByStoreIdAndYear(@Param("storeId") Long storeId,
                                                                                                                @Param("year") int year);

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
            AND FUNCTION('YEAR', o.orderTime) = :year
            AND FUNCTION('MONTH', o.orderTime) = :month
            GROUP BY ls.laundrySuppliesId, ls.laundrySuppliesName, ls.laundrySuppliesClassification, ls.laundrySuppliesPrice, o.store.storeId
            ORDER BY totalSales DESC
            """)
    List<LaundrySuppliesAndStoreIdAndTotalSalesProjection> findTop5ByOrderCountByStoreIdAndYearAndMonth(@Param("storeId") Long storeId,
                                                                                         @Param("year") int year,
                                                                                         @Param("month") int month);

}
