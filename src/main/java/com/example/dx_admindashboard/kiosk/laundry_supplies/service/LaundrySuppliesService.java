package com.example.dx_admindashboard.kiosk.laundry_supplies.service;

import com.example.dx_admindashboard.kiosk.laundry_supplies.domain.dto.join.LaundrySuppliesInfoAndStoreIdAndStoreCountProjectionDTO;
import com.example.dx_admindashboard.kiosk.laundry_supplies.domain.dto.join.LaundrySuppliesInfoAndStoreIdAndTotalSalesProjectionDTO;
import com.example.dx_admindashboard.kiosk.laundry_supplies.domain.dto.join.MonthAndSalesCountAndStoreIdByLaundrySuppliesIdProjectionDTO;
import com.example.dx_admindashboard.kiosk.laundry_supplies.domain.projection.LaundrySuppliesInfoAndStoreIdAndTotalSalesProjection;
import com.example.dx_admindashboard.kiosk.laundry_supplies.repository.LaundrySuppliesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LaundrySuppliesService {

    private final LaundrySuppliesRepository laundrySuppliesRepository;

    @Transactional
    public List<LaundrySuppliesInfoAndStoreIdAndStoreCountProjectionDTO> getLaundrySuppliesByStoreId(Long storeId) {

    }

    @Transactional
    public List<MonthAndSalesCountAndStoreIdByLaundrySuppliesIdProjectionDTO> getLaundrySuppliesSalesCountByLaundrySuppliesIdAndStoreIdAndYear(Long laundrySuppliesId,
                                                                                                                                               Long storeId,
                                                                                                                                               Integer year) {

    }

    @Transactional
    public List<LaundrySuppliesInfoAndStoreIdAndTotalSalesProjectionDTO> getLaundrySuppliesSalesCountTop5ByStoreIdAndYear(Long storeId,
                                                                                                                          Integer year) {
        return null;
    }

    @Transactional
    public List<LaundrySuppliesInfoAndStoreIdAndTotalSalesProjection> getLaundrySuppliesSalesCountTop5ByStoreIdAndYearAndMonth(Long storeId,
                                                                                                                               Integer year,
                                                                                                                               Integer month) {


    }
}



