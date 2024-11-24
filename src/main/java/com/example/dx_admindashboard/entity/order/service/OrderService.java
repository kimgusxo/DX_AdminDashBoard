package com.example.dx_admindashboard.entity.order.service;

import com.example.dx_admindashboard.exception.ListEmptyException;
import com.example.dx_admindashboard.entity.kiosk.mealkit.repository.MealKitRepository;
import com.example.dx_admindashboard.entity.order.domain.dto.join.MonthAndTotalRevenueAndStoreIdByYearProjectionDTO;
import com.example.dx_admindashboard.entity.order.domain.dto.join.MonthAndVisitorCountAndStoreIdByYearProjectionDTO;
import com.example.dx_admindashboard.entity.order.domain.projection.MonthAndTotalRevenueAndStoreIdByYearProjection;
import com.example.dx_admindashboard.entity.order.domain.projection.MonthAndVisitorCountAndStoreIdByYearProjection;
import com.example.dx_admindashboard.entity.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final MealKitRepository mealKitRepository;

    @Transactional
    public List<MonthAndTotalRevenueAndStoreIdByYearProjectionDTO> getTotalRevenueListByStoreIdAndYear(Long storeId,
                                                                                                       Integer year) {
        List<MonthAndTotalRevenueAndStoreIdByYearProjection> results =
                orderRepository.findTotalRevenueListByStoreIdAndYear(storeId, year);

        if(results.isEmpty()) {
            throw new ListEmptyException();
        }

        List<MonthAndTotalRevenueAndStoreIdByYearProjectionDTO> resultsDTO = new ArrayList<>();

        results.forEach(r -> {
            resultsDTO.add(MonthAndTotalRevenueAndStoreIdByYearProjectionDTO.from(r));
        });

        return resultsDTO;
    }

    @Transactional
    public List<MonthAndVisitorCountAndStoreIdByYearProjectionDTO> getVisitorCountListByStoreIdAndYear(Long storeId,
                                                                                                       Integer year) {
        List<MonthAndVisitorCountAndStoreIdByYearProjection> results =
                orderRepository.findVisitorCountListByStoreIdAndYear(storeId, year);

        if(results.isEmpty()) {
            throw new ListEmptyException();
        }

        List<MonthAndVisitorCountAndStoreIdByYearProjectionDTO> resultsDTO = new ArrayList<>();

        results.forEach(r -> {
            resultsDTO.add(MonthAndVisitorCountAndStoreIdByYearProjectionDTO.from(r));
        });

        return resultsDTO;
    }
}
