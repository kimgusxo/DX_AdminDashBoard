package com.example.dx_admindashboard.kiosk.mealkit.service;

import com.example.dx_admindashboard.kiosk.mealkit.domain.dto.join.MealKitInfoAndStoreIdAndMealKitCountProjectionDTO;
import com.example.dx_admindashboard.kiosk.mealkit.domain.dto.join.MealKitInfoAndStoreIdAndMonthlyTotalRevenueProjectionDTO;
import com.example.dx_admindashboard.kiosk.mealkit.domain.dto.join.MealKitInfoAndStoreIdAndTotalSalesProjectionDTO;
import com.example.dx_admindashboard.kiosk.mealkit.domain.dto.join.MonthAndSalesCountAndStoreIdByMealKitIdAndYearProjectionDTO;
import com.example.dx_admindashboard.kiosk.mealkit.repository.MealKitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MealKitService {

    private final MealKitRepository mealKitRepository;

    @Transactional
    public List<MealKitInfoAndStoreIdAndMealKitCountProjectionDTO> getMealKitListByStoreId(Long storeId) {


    }

    @Transactional
    public List<MonthAndSalesCountAndStoreIdByMealKitIdAndYearProjectionDTO> getMealKitSalesCountByMealKitIdAndStoreIdAndYear(Long mealKitId,
                                                                                                                              Long storeId,
                                                                                                                              Integer year) {
    }

    @Transactional
    public List<MealKitInfoAndStoreIdAndTotalSalesProjectionDTO> getMealKitSalesCountTop5ByStoreIdAndYear(Long storeId,
                                                                                                          Integer year) {
    }

    @Transactional
    public List<MealKitInfoAndStoreIdAndTotalSalesProjectionDTO> getMealKitSalesCountTop5ByStoreIdAndYearAndMonth(Long storeId,
                                                                                                                  Integer year,
                                                                                                                  Integer month) {
    }

    @Transactional
    public List<MealKitInfoAndStoreIdAndMonthlyTotalRevenueProjectionDTO> getMealKitSalesRevenueTop5ByStoreIdAndYearAndMonth(Long storeId,
                                                                                                                             Integer year,
                                                                                                                             Integer month) {
    }

    @Transactional
    public List<MealKitInfoAndStoreIdAndTotalSalesProjectionDTO> getMealKitSalesCountTop5ByStoreId(Long storeId) {
    }
}
