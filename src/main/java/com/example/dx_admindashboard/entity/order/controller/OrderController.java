package com.example.dx_admindashboard.entity.order.controller;

import com.example.dx_admindashboard.entity.order.domain.dto.join.MonthAndTotalRevenueAndStoreIdByYearProjectionDTO;
import com.example.dx_admindashboard.entity.order.domain.dto.join.MonthAndVisitorCountAndStoreIdByYearProjectionDTO;
import com.example.dx_admindashboard.entity.order.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/get/list/month/revenue")
    @Operation(summary = "Get TotalRevenue By Year", description = "매장 별 해당년도의 월 별 총 매출액")
    public ResponseEntity<List<MonthAndTotalRevenueAndStoreIdByYearProjectionDTO>> getTotalRevenueListByStoreIdAndYear(@RequestParam Long storeId,
                                                                                                                       @RequestParam Integer year) {
        log.info("getTotalRevenueListByStoreIdAndYear : storeId = {}, year = {}", storeId, year);
        return new ResponseEntity<>(orderService.getTotalRevenueListByStoreIdAndYear(storeId, year), HttpStatus.OK);
    }

    @GetMapping("/get/list/month/visitorCount")
    @Operation(summary = "Get VisitorCount By Year", description = "매장 별 해당년도의 월 별 총 고객 수")
    public ResponseEntity<List<MonthAndVisitorCountAndStoreIdByYearProjectionDTO>> getVisitorCountListByStoreIdAndYear(@RequestParam Long storeId,
                                                                                                                       @RequestParam Integer year) {
        log.info("getVisitorCountListByStoreIdAndYear : storeId = {}, year = {}", storeId, year);
        return new ResponseEntity<>(orderService.getVisitorCountListByStoreIdAndYear(storeId, year), HttpStatus.OK);
    }

}
