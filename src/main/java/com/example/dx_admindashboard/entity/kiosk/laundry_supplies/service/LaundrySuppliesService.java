package com.example.dx_admindashboard.entity.kiosk.laundry_supplies.service;

import com.example.dx_admindashboard.exception.ListEmptyException;
import com.example.dx_admindashboard.entity.kiosk.laundry_supplies.domain.dto.join.LaundrySuppliesInfoAndStoreIdAndStoreCountProjectionDTO;
import com.example.dx_admindashboard.entity.kiosk.laundry_supplies.domain.dto.join.LaundrySuppliesInfoAndStoreIdAndTotalSalesProjectionDTO;
import com.example.dx_admindashboard.entity.kiosk.laundry_supplies.domain.dto.join.MonthAndSalesCountAndStoreIdByLaundrySuppliesIdProjectionDTO;
import com.example.dx_admindashboard.entity.kiosk.laundry_supplies.domain.projection.LaundrySuppliesInfoAndStoreIdAndStoreCountProjection;
import com.example.dx_admindashboard.entity.kiosk.laundry_supplies.domain.projection.LaundrySuppliesInfoAndStoreIdAndTotalSalesProjection;
import com.example.dx_admindashboard.entity.kiosk.laundry_supplies.domain.projection.MonthAndSalesCountAndStoreIdByLaundrySuppliesIdProjection;
import com.example.dx_admindashboard.entity.kiosk.laundry_supplies.repository.LaundrySuppliesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LaundrySuppliesService {

    private final LaundrySuppliesRepository laundrySuppliesRepository;

    @Transactional
    public List<LaundrySuppliesInfoAndStoreIdAndStoreCountProjectionDTO> getLaundrySuppliesByStoreId(Long storeId) {
        List<LaundrySuppliesInfoAndStoreIdAndStoreCountProjection> results =
                laundrySuppliesRepository.findLaundrySuppliesByStoreId(storeId);

        if (results.isEmpty()) {
            throw new ListEmptyException();
        }

        List<LaundrySuppliesInfoAndStoreIdAndStoreCountProjectionDTO> resultsDTO = new ArrayList<>();

        results.forEach(r -> {
            resultsDTO.add(LaundrySuppliesInfoAndStoreIdAndStoreCountProjectionDTO.from(r));
        });

        return resultsDTO;
    }

    @Transactional
    public List<MonthAndSalesCountAndStoreIdByLaundrySuppliesIdProjectionDTO> getLaundrySuppliesSalesCountByLaundrySuppliesIdAndStoreIdAndYear(Long laundrySuppliesId,
                                                                                                                                               Long storeId,
                                                                                                                                               Integer year) {
        List<MonthAndSalesCountAndStoreIdByLaundrySuppliesIdProjection> result =
                laundrySuppliesRepository.findLaundrySuppliesSalesCountByLaundrySuppliesIdAndStoreIdAndYear(laundrySuppliesId, storeId, year);

        if (result.isEmpty()) {
            throw new ListEmptyException();
        }

        List<MonthAndSalesCountAndStoreIdByLaundrySuppliesIdProjectionDTO> resultsDTO = new ArrayList<>();

        result.forEach(r -> {
           resultsDTO.add(MonthAndSalesCountAndStoreIdByLaundrySuppliesIdProjectionDTO.from(r));
        });

        return resultsDTO;
    }

    @Transactional
    public List<LaundrySuppliesInfoAndStoreIdAndTotalSalesProjectionDTO> getLaundrySuppliesSalesCountTop5ByStoreIdAndYear(Long storeId,
                                                                                                                          Integer year) {
        Pageable pageable = PageRequest.of(0, 5);

        List<LaundrySuppliesInfoAndStoreIdAndTotalSalesProjection> results =
                laundrySuppliesRepository.findLaundrySuppliesSalesCountTop5ByStoreIdAndYear(storeId, year, pageable);

        if (results.isEmpty()) {
            throw new ListEmptyException();
        }

        List<LaundrySuppliesInfoAndStoreIdAndTotalSalesProjectionDTO> resultsDTO = new ArrayList<>();

        results.forEach(r -> {
            resultsDTO.add(LaundrySuppliesInfoAndStoreIdAndTotalSalesProjectionDTO.from(r));
        });

        return resultsDTO;
    }

    @Transactional
    public List<LaundrySuppliesInfoAndStoreIdAndTotalSalesProjectionDTO> getLaundrySuppliesSalesCountTop5ByStoreIdAndYearAndMonth(Long storeId,
                                                                                                                               Integer year,
                                                                                                                               Integer month) {
        Pageable pageable = PageRequest.of(0, 5);

        List<LaundrySuppliesInfoAndStoreIdAndTotalSalesProjection> results =
                laundrySuppliesRepository.findLaundrySuppliesSalesCountTop5ByStoreIdAndYearAndMonth(storeId, year, month, pageable);

        if (results.isEmpty()) {
            throw new ListEmptyException();
        }

        List<LaundrySuppliesInfoAndStoreIdAndTotalSalesProjectionDTO> resultsDTO = new ArrayList<>();

        results.forEach(r -> {
            resultsDTO.add(LaundrySuppliesInfoAndStoreIdAndTotalSalesProjectionDTO.from(r));
        });

        return resultsDTO;
    }
}



