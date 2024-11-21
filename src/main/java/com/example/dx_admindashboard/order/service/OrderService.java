package com.example.dx_admindashboard.order.service;

import com.example.dx_admindashboard.order.domain.dto.join.MonthAndTotalRevenueAndStoreIdByYearProjectionDTO;
import com.example.dx_admindashboard.order.domain.dto.join.MonthAndVisitorCountAndStoreIdByYearProjectionDTO;
import com.example.dx_admindashboard.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    @Transactional
    public List<MonthAndTotalRevenueAndStoreIdByYearProjectionDTO> getTotalRevenueListByStoreIdAndYear(Long storeId,
                                                                                                       Integer year) {
    }

    @Transactional
    public List<MonthAndVisitorCountAndStoreIdByYearProjectionDTO> getVisitorCountListByStoreIdAndYear(Long storeId,
                                                                                                       Integer year) {
    }
}
