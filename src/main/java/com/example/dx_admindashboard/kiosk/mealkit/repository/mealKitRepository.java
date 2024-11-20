package com.example.dx_admindashboard.kiosk.mealkit.repository;

import com.example.dx_admindashboard.kiosk.mealkit.domain.MealKit;
import com.example.dx_admindashboard.kiosk.mealkit.projection.MealKitAndMonthlySalesRevenueProjection;
import com.example.dx_admindashboard.kiosk.mealkit.projection.MealKitAndSalesProjection;
import com.example.dx_admindashboard.kiosk.mealkit.projection.MealKitMonthlySalesProjection;
import com.example.dx_admindashboard.kiosk.mealkit.projection.MealKitAndCountProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface mealKitRepository extends JpaRepository<MealKit, Long> {

    // 밀키트 재고 페이지 1번
    @Query("""
            SELECT mk.mealKitId AS mealKitId,
                   mk.mealKitName AS mealKitName,
                   mk.mealKitClassification AS mealKitClassification,
                   mk.mealKitFoodClassification AS mealKitFoodClassification,
                   mk.mealKitPrice AS mealKitPrice,
                   mc.store.storeId AS storeId,
                   mc.mealKitCount AS mealKitCount
            FROM MealKit mk
            JOIN MealKitCounter mc ON mk.mealKitId = mc.mealKit.mealKitId
            WHERE mc.store.storeId = :storeId
           """)
    List<MealKitAndCountProjection> findStoreIdBymealKitAndCountProjectionList(Long storeId);

    // 밀키트 재고 페이지 2번
    @Query("""
            SELECT FUNCTION('MONTH', o.orderTime) AS month,
                   COUNT(mko) AS salesCount
            FROM MealKitOrder mko
            JOIN mko.order o
            WHERE mko.mealKit.mealKitId = :mealKitId
            AND o.store.storeId = :storeId
            AND FUNCTION('YEAR', o.orderTime) = :year
            GROUP BY FUNCTION('MONTH', o.orderTime)
            ORDER BY FUNCTION('MONTH', o.orderTime)
            """)
    List<MealKitMonthlySalesProjection> findMonthlySalesForYearByMealKitIdAndStoreId(Long mealKitId, Long storeId, int year);

    // 밀키트 재고 페이지 3번(연도 별)
    @Query("""
            SELECT mk.mealKitId AS mealKitId,
                   mk.mealKitName AS mealKitName,
                   mk.mealKitClassification AS mealKitClassification,
                   mk.mealKitFoodClassification AS mealKitFoodClassification,
                   o.store.storeId AS storeId,
                   mk.mealKitPrice AS mealKitPrice,
                   COUNT(mko) AS totalSales
            FROM MealKit mk
            JOIN MealKitOrder mko ON mk.mealKitId = mko.mealKit.mealKitId
            JOIN mko.order o
            WHERE o.store.storeId = :storeId
            AND FUNCTION('YEAR', o.orderTime) = :year
            GROUP BY mk.mealKitId
            ORDER BY totalSales DESC
            """)
    List<MealKitAndSalesProjection> findTop5ByOrderCountByStoreIdAndYear(Long storeId, int year);

    // 밀키트 재고 페이지 3번(연도/월 별)
    @Query("""
            SELECT mk.mealKitId AS mealKitId,
                   mk.mealKitName AS mealKitName,
                   mk.mealKitClassification AS mealKitClassification,
                   mk.mealKitFoodClassification AS mealKitFoodClassification,
                   o.store.storeId AS storeId,
                   mk.mealKitPrice AS mealKitPrice,
                   COUNT(mko) AS totalSales
            FROM MealKit mk
            JOIN MealKitOrder mko ON mk.mealKitId = mko.mealKit.mealKitId
            JOIN mko.order o
            WHERE o.store.storeId = :storeId
            AND FUNCTION('YEAR', o.orderTime) = :year
            AND FUNCTION('MONTH', o.orderTime) = :month
            GROUP BY mk.mealKitId
            ORDER BY totalSales DESC
            """)
    List<MealKitAndSalesProjection> findTop5ByOrderCountByStoreIdAndYearAndMonth(Long storeId, int year, int month);

    // Main 페이지 4번 사용
    @Query("""
            SELECT mk.mealKitId AS mealKitId,
                   mk.mealKitName AS mealKitName,
                   mk.mealKitClassification AS mealKitClassification,
                   mk.mealKitFoodClassification AS mealKitFoodClassification,
                   o.store.storeId AS storeId,
                   mk.mealKitPrice AS mealKitPrice,
                   SUM(mk.mealKitPrice * COUNT(mko)) AS totalRevenue
            FROM MealKit mk
            JOIN MealKitOrder mko ON mk.mealKitId = mko.mealKit.mealKitId
            JOIN mko.order o
            WHERE FUNCTION('YEAR', o.orderTime) = :year
            AND FUNCTION('MONTH', o.orderTime) = :month
            GROUP BY mk.mealKitId
            ORDER BY totalRevenue DESC
            """)
    List<MealKitAndMonthlySalesRevenueProjection> findTop5ByTotalRevenueForMonth(int year, int month);


    // Main 페이지 6번 사용
    @Query("""
            SELECT mk.mealKitId AS mealKitId,
                   mk.mealKitName AS mealKitName,
                   mk.mealKitClassification AS mealKitClassification,
                   mk.mealKitFoodClassification AS mealKitFoodClassification,
                   o.store.storeId AS storeId,
                   mk.mealKitPrice AS mealKitPrice,
                   COUNT(mko) AS totalSales
            FROM MealKit mk
            JOIN MealKitOrder mko ON mk.mealKitId = mko.mealKit.mealKitId
            JOIN mko.order o
            WHERE o.store.storeId = :storeId
            GROUP BY mk.mealKitId
            ORDER BY totalSales DESC
            """)
    List<MealKitAndSalesProjection> findTop5ByOrderCountByStoreId(Long storeId);


}
