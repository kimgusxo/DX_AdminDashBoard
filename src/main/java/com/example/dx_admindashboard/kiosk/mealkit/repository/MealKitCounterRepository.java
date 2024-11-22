package com.example.dx_admindashboard.kiosk.mealkit.repository;

import com.example.dx_admindashboard.kiosk.mealkit.domain.MealKitCounter;
import com.example.dx_admindashboard.kiosk.mealkit.domain.dto.MealKitCounterDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface MealKitCounterRepository extends JpaRepository<MealKitCounter, Long> {
    @Modifying
    @Query("""
        UPDATE MealKitCounter mkc
        SET mkc.mealKitCount = :#{#mkcd.mealKitCount}
        WHERE mkc.mealKit.mealKitId = :#{#mkcd.mealKitId}
        AND mkc.store.storeId = :#{#mkcd.storeId}
        """)
    Integer updateMealKitCounter(@Param("mkcd") MealKitCounterDTO mealKitCounterDTO);
}
