package com.example.dx_admindashboard.kiosk.mealkit.service;

import com.example.dx_admindashboard.exception.ListEmptyException;
import com.example.dx_admindashboard.kiosk.mealkit.domain.dto.join.MealKitInfoAndStoreIdAndMealKitCountProjectionDTO;
import com.example.dx_admindashboard.kiosk.mealkit.domain.dto.join.MealKitInfoAndStoreIdAndMonthlyTotalRevenueProjectionDTO;
import com.example.dx_admindashboard.kiosk.mealkit.domain.dto.join.MealKitInfoAndStoreIdAndTotalSalesProjectionDTO;
import com.example.dx_admindashboard.kiosk.mealkit.domain.dto.join.MonthAndSalesCountAndStoreIdByMealKitIdAndYearProjectionDTO;
import com.example.dx_admindashboard.kiosk.mealkit.domain.projection.MealKitInfoAndStoreIdAndMealKitCountProjection;
import com.example.dx_admindashboard.kiosk.mealkit.domain.projection.MealKitInfoAndStoreIdAndMonthlyTotalRevenueProjection;
import com.example.dx_admindashboard.kiosk.mealkit.domain.projection.MealKitInfoAndStoreIdAndTotalSalesProjection;
import com.example.dx_admindashboard.kiosk.mealkit.domain.projection.MonthAndSalesCountAndStoreIdByMealKitIdAndYearProjection;
import com.example.dx_admindashboard.kiosk.mealkit.repository.MealKitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MealKitService {

    private final MealKitRepository mealKitRepository;

    @Transactional
    public List<MealKitInfoAndStoreIdAndMealKitCountProjectionDTO> getMealKitListByStoreId(Long storeId) {
        List<MealKitInfoAndStoreIdAndMealKitCountProjection> results =
                mealKitRepository.findMealKitListByStoreId(storeId);

        if (results.isEmpty()) {
            throw new ListEmptyException();
        }

        List<MealKitInfoAndStoreIdAndMealKitCountProjectionDTO> resultsDTO = new ArrayList<>();

        results.forEach(r -> {
            resultsDTO.add(MealKitInfoAndStoreIdAndMealKitCountProjectionDTO.from(r));
        });

        return resultsDTO;
    }

    @Transactional
    public List<MonthAndSalesCountAndStoreIdByMealKitIdAndYearProjectionDTO> getMealKitSalesCountByMealKitIdAndStoreIdAndYear(Long mealKitId,
                                                                                                                              Long storeId,
                                                                                                                              Integer year) {
        List<MonthAndSalesCountAndStoreIdByMealKitIdAndYearProjection> results =
                mealKitRepository.findMealKitSalesCountByMealKitIdAndStoreIdAndYear(mealKitId, storeId, year);

        if (results.isEmpty()) {
            throw new ListEmptyException();
        }

        List<MonthAndSalesCountAndStoreIdByMealKitIdAndYearProjectionDTO> resultsDTO = new ArrayList<>();

        results.forEach(r -> {
            resultsDTO.add(MonthAndSalesCountAndStoreIdByMealKitIdAndYearProjectionDTO.from(r));
        });

        return resultsDTO;
    }

    @Transactional
    public List<MealKitInfoAndStoreIdAndTotalSalesProjectionDTO> getMealKitSalesCountTop5ByStoreIdAndYear(Long storeId,
                                                                                                          Integer year) {
        Pageable pageable = PageRequest.of(0, 5);

        List<MealKitInfoAndStoreIdAndTotalSalesProjection> results =
                mealKitRepository.findMealKitSalesCountTop5ByStoreIdAndYear(storeId, year, pageable);

        if (results.isEmpty()) {
            throw new ListEmptyException();
        }

        List<MealKitInfoAndStoreIdAndTotalSalesProjectionDTO> resultsDTO = new ArrayList<>();

        results.forEach(r -> {
            resultsDTO.add(MealKitInfoAndStoreIdAndTotalSalesProjectionDTO.from(r));
        });

        return resultsDTO;
    }

    @Transactional
    public List<MealKitInfoAndStoreIdAndTotalSalesProjectionDTO> getMealKitSalesCountTop5ByStoreIdAndYearAndMonth(Long storeId,
                                                                                                                  Integer year,
                                                                                                                  Integer month) {
        Pageable pageable = PageRequest.of(0, 5);

        List<MealKitInfoAndStoreIdAndTotalSalesProjection> results =
                mealKitRepository.findMealKitSalesCountTop5ByStoreIdAndYearAndMonth(storeId, year, month, pageable);

        if (results.isEmpty()) {
            throw new ListEmptyException();
        }

        List<MealKitInfoAndStoreIdAndTotalSalesProjectionDTO> resultsDTO = new ArrayList<>();

        results.forEach(r -> {
            resultsDTO.add(MealKitInfoAndStoreIdAndTotalSalesProjectionDTO.from(r));
        });

        return resultsDTO;
    }

    @Transactional
    public List<MealKitInfoAndStoreIdAndMonthlyTotalRevenueProjectionDTO> getMealKitSalesRevenueTop5ByStoreIdAndYearAndMonth(Long storeId,
                                                                                                                             Integer year,
                                                                                                                             Integer month) {
        Pageable pageable = PageRequest.of(0, 5);

        List<MealKitInfoAndStoreIdAndMonthlyTotalRevenueProjection> results =
                mealKitRepository.findMealKitSalesRevenueTop5ByStoreIdAndYearAndMonth(storeId, year, month, pageable);

        if (results.isEmpty()) {
            throw new ListEmptyException();
        }

        List<MealKitInfoAndStoreIdAndMonthlyTotalRevenueProjectionDTO> resultsDTO = new ArrayList<>();

        results.forEach(r -> {
            resultsDTO.add(MealKitInfoAndStoreIdAndMonthlyTotalRevenueProjectionDTO.from(r));
        });

        return resultsDTO;
    }

    @Transactional
    public List<MealKitInfoAndStoreIdAndTotalSalesProjectionDTO> getMealKitSalesCountTop5ByStoreId(Long storeId) {
        Pageable pageable = PageRequest.of(0, 5);

        List<MealKitInfoAndStoreIdAndTotalSalesProjection> results =
                mealKitRepository.findMealKitSalesCountTop5ByStoreId(storeId, pageable);

        if (results.isEmpty()) {
            throw new ListEmptyException();
        }

        List<MealKitInfoAndStoreIdAndTotalSalesProjectionDTO> resultsDTO = new ArrayList<>();

        results.forEach(r -> {
            resultsDTO.add(MealKitInfoAndStoreIdAndTotalSalesProjectionDTO.from(r));
        });

        return resultsDTO;
    }
}
