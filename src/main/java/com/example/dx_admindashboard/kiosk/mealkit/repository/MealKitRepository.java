package com.example.dx_admindashboard.kiosk.mealkit.repository;

import com.example.dx_admindashboard.kiosk.mealkit.domain.MealKit;
import com.example.dx_admindashboard.kiosk.mealkit.domain.projection.MealKitInfoAndStoreIdAndMonthlyTotalRevenueProjection;
import com.example.dx_admindashboard.kiosk.mealkit.domain.projection.MealKitInfoAndStoreIdAndMealKitCountProjection;
import com.example.dx_admindashboard.kiosk.mealkit.domain.projection.MealKitInfoAndStoreIdAndTotalSalesProjection;
import com.example.dx_admindashboard.kiosk.mealkit.domain.projection.MonthAndSalesCountAndStoreIdByMealKitIdAndYearProjection;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealKitRepository extends JpaRepository<MealKit, Long> {

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
    List<MealKitInfoAndStoreIdAndMealKitCountProjection> findMealKitListByStoreId(@Param("storeId") Long storeId);

    // 주문 페이지 1번 (재고 10개 미만)
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
            AND mc.mealKitCount < :remainCount
           """)
    List<MealKitInfoAndStoreIdAndMealKitCountProjection> findMealKitListByStoreIdAndLessThan10(@Param("storeId") Long storeId,
                                                                                  @Param("reaminCount") Integer reaminCount);

    // 밀키트 재고 페이지 2번
    @Query("""
            SELECT EXTRACT(MONTH FROM o.orderTime) AS month,
                   COUNT(mko) AS salesCount,
                   o.store.storeId AS storeId
            FROM MealKitOrder mko
            JOIN mko.order o
            WHERE mko.mealKit.mealKitId = :mealKitId
            AND o.store.storeId = :storeId
            AND EXTRACT(YEAR FROM o.orderTime) = :year
            GROUP BY EXTRACT(MONTH FROM o.orderTime), o.store.storeId
            ORDER BY EXTRACT(MONTH FROM o.orderTime)
            """)
    List<MonthAndSalesCountAndStoreIdByMealKitIdAndYearProjection> findMealKitSalesCountByMealKitIdAndStoreIdAndYear(@Param("mealKitId") Long mealKitId,
                                                                                                                     @Param("storeId") Long storeId,
                                                                                                                     @Param("year") Integer year);

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
            AND EXTRACT(YEAR FROM o.orderTime) = :year
            GROUP BY mk.mealKitId, o.store.storeId
            ORDER BY totalSales DESC
            """)
    List<MealKitInfoAndStoreIdAndTotalSalesProjection> findMealKitSalesCountTop5ByStoreIdAndYear(@Param("storeId") Long storeId,
                                                                                                 @Param("year") Integer year,
                                                                                                 Pageable pageable);

    // 밀키트 재고 페이지 3번(연도/월 별)
    @Query("""
            SELECT mk.mealKitId AS mealKitId,
                   mk.mealKitName AS mealKitName,
                   mk.mealKitClassification AS mealKitClassification,
                   mk.mealKitFoodClassification AS mealKitFoodClassification,
                   mk.mealKitPrice AS mealKitPrice,
                   o.store.storeId AS storeId,
                   COUNT(mko) AS totalSales
            FROM MealKit mk
            JOIN MealKitOrder mko ON mk.mealKitId = mko.mealKit.mealKitId
            JOIN mko.order o
            WHERE o.store.storeId = :storeId
            AND EXTRACT(MONTH FROM o.orderTime) = :year
            AND EXTRACT(YEAR FROM o.orderTime) = :month
            GROUP BY mk.mealKitId, o.store.storeId
            ORDER BY totalSales DESC
            """)
    List<MealKitInfoAndStoreIdAndTotalSalesProjection> findMealKitSalesCountTop5ByStoreIdAndYearAndMonth(@Param("storeId") Long storeId,
                                                                                                         @Param("year") Integer year,
                                                                                                         @Param("month") Integer month,
                                                                                                         Pageable pageable);

    // Main 페이지 4번 사용
    @Query("""
            SELECT mk.mealKitId AS mealKitId,
                   mk.mealKitName AS mealKitName,
                   mk.mealKitClassification AS mealKitClassification,
                   mk.mealKitFoodClassification AS mealKitFoodClassification,
                   o.store.storeId AS storeId,
                   mk.mealKitPrice AS mealKitPrice,
                   SUM(mk.mealKitPrice * COUNT(mko)) AS monthlyTotalRevenue
            FROM MealKit mk
            JOIN MealKitOrder mko ON mk.mealKitId = mko.mealKit.mealKitId
            JOIN mko.order o
            WHERE o.store.storeId = :storeId
            AND EXTRACT(YEAR FROM o.orderTime) = :year
            AND EXTRACT(MONTH FROM o.orderTime) = :month
            GROUP BY mk.mealKitId, o.store.storeId
            ORDER BY monthlyTotalRevenue DESC
            """)
    List<MealKitInfoAndStoreIdAndMonthlyTotalRevenueProjection> findMealKitSalesRevenueTop5ByStoreIdAndYearAndMonth(@Param("storeId") Long storeId,
                                                                                                                    @Param("year") Integer year,
                                                                                                                    @Param("month") Integer month,
                                                                                                                    Pageable pageable);


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
            GROUP BY mk.mealKitId, o.store.storeId
            ORDER BY totalSales DESC
            """)
    List<MealKitInfoAndStoreIdAndTotalSalesProjection> findMealKitSalesCountTop5ByStoreId(@Param("storeId") Long storeId,
                                                                                          Pageable pageable);


}
