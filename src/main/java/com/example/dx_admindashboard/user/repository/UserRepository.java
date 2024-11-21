package com.example.dx_admindashboard.user.repository;

import com.example.dx_admindashboard.user.domain.User;
import com.example.dx_admindashboard.user.domain.projection.MealKitAndUserFeatureSalesAndStoreIdProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // 고객 페이지 1번 / 2번 / 3번
    @Query("""
            SELECT DISTINCT u
            FROM User u
            JOIN u.orderList o
            WHERE o.store.storeId = :storeId
            """)
    List<User> findUsersByStoreId(@Param("storeId") Long storeId);

    // 고객 페이지 4번
    @Query("""
            SELECT mk.mealKitId AS mealKitId,
                   mk.mealKitName AS mealKitName,
                   mk.mealKitClassification AS mealKitClassification,
                   mk.mealKitFoodClassification AS mealKitFoodClassification,
                   mk.mealKitPrice AS mealKitPrice,
                   COUNT(mko) AS totalSales,
                   o.store.storeId AS storeId
            FROM MealKit mk
            JOIN MealKitOrder mko ON mk.mealKitId = mko.mealKit.mealKitId
            JOIN mko.order o
            JOIN o.user u
            WHERE o.store.storeId = :storeId
            AND u.userGender = :gender
            GROUP BY mk.mealKitId
            ORDER BY totalSales DESC
            """)
    List<MealKitAndUserFeatureSalesAndStoreIdProjection> findTop5ByGenderAndStoreId(@Param("storeId") Long storeId,
                                                                                    @Param("gender") String gender);

    // 고객 페이지 5번
    @Query("""
            SELECT mk.mealKitId AS mealKitId,
                   mk.mealKitName AS mealKitName,
                   mk.mealKitClassification AS mealKitClassification,
                   mk.mealKitFoodClassification AS mealKitFoodClassification,
                   mk.mealKitPrice AS mealKitPrice,
                   COUNT(mko) AS totalSales,
                   o.store.storeId AS storeId
            FROM MealKit mk
            JOIN MealKitOrder mko ON mk.mealKitId = mko.mealKit.mealKitId
            JOIN mko.order o
            JOIN o.user u
            WHERE o.store.storeId = :storeId
            AND u.userAge = :age
            GROUP BY mk.mealKitId
            ORDER BY totalSales DESC
            """)
    List<MealKitAndUserFeatureSalesAndStoreIdProjection> findTop5ByAgeAndStoreId(@Param("storeId") Long storeId,
                                                                       @Param("age") Integer age);

}
