package com.example.dx_admindashboard.kiosk.laundry_supplies.controller;

import com.example.dx_admindashboard.kiosk.laundry_supplies.domain.dto.join.LaundrySuppliesInfoAndStoreIdAndStoreCountProjectionDTO;
import com.example.dx_admindashboard.kiosk.laundry_supplies.domain.dto.join.LaundrySuppliesInfoAndStoreIdAndTotalSalesProjectionDTO;
import com.example.dx_admindashboard.kiosk.laundry_supplies.domain.dto.join.MonthAndSalesCountAndStoreIdByLaundrySuppliesIdProjectionDTO;
import com.example.dx_admindashboard.kiosk.laundry_supplies.domain.projection.LaundrySuppliesInfoAndStoreIdAndStoreCountProjection;
import com.example.dx_admindashboard.kiosk.laundry_supplies.domain.projection.LaundrySuppliesInfoAndStoreIdAndTotalSalesProjection;
import com.example.dx_admindashboard.kiosk.laundry_supplies.domain.projection.MonthAndSalesCountAndStoreIdByLaundrySuppliesIdProjection;
import com.example.dx_admindashboard.kiosk.laundry_supplies.service.LaundrySuppliesService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/laundrySupplies")
@RequiredArgsConstructor
public class LaundrySuppliesController {

    private final LaundrySuppliesService laundrySuppliesService;

    @GetMapping("/get/list/{storeId}")
    @Operation(summary = "Get LaundrySuppliesList", description = "매장 별 세탁용품 리스트 가져오기")
    public ResponseEntity<List<LaundrySuppliesInfoAndStoreIdAndStoreCountProjectionDTO>> getLaundrySuppliesListByStoreId(@PathVariable Long storeId) {
        log.info("getLaundrySuppliesByStoreId : storeId = {}", storeId);
        return new ResponseEntity<>(laundrySuppliesService.getLaundrySuppliesByStoreId(storeId), HttpStatus.OK);
    }

    @GetMapping("/get/one/month/count")
    @Operation(summary = "Get LaundrySuppliesSalesCount By LaundrySuppliesId And Year", description = "매장 별 세탁용품 별 해당 연도의 월별 판매량")
    public ResponseEntity<List<MonthAndSalesCountAndStoreIdByLaundrySuppliesIdProjectionDTO>> getLaundrySuppliesSalesCountByLaundrySuppliesIdAndStoreIdAndYear(@RequestParam Long laundrySuppliesId,
                                                                                                                                                               @RequestParam Long storeId,
                                                                                                                                                               @RequestParam Integer year) {
        log.info("getLaundrySuppliesSalesCountByLaundrySuppliesIdAndStoreIdAndYear : laundrySuppliesId = {}, storeId = {}, year = {}", laundrySuppliesId, storeId, year);
        return new ResponseEntity<>(laundrySuppliesService.getLaundrySuppliesSalesCountByLaundrySuppliesIdAndStoreIdAndYear(laundrySuppliesId, storeId, year), HttpStatus.OK);
    }

    @GetMapping("/get/top5/year/count")
    @Operation(summary = "Get LaundrySuppliesSalesCountTop5 By Year", description = "매장 별 세탁용품 연도별 판매량 TOP 5")
    public ResponseEntity<List<LaundrySuppliesInfoAndStoreIdAndTotalSalesProjectionDTO>> getLaundrySuppliesSalesCountTop5ByStoreIdAndYear(@RequestParam Long storeId,
                                                                                                                                          @RequestParam Integer year) {
        log.info("getLaundrySuppliesSalesCountTop5ByStoreIdAndYear : storeId = {}, year = {}", storeId, year);
        return new ResponseEntity<>(laundrySuppliesService.getLaundrySuppliesSalesCountTop5ByStoreIdAndYear(storeId, year), HttpStatus.OK);
    }

    @GetMapping("/get/top5/month/count")
    @Operation(summary = "Get LaundrySuppliesSalesCountTop5 By Year And Month", description = "매장 별 세탁용품 해당 연도의 월별 판매량 TOP 5")
    public ResponseEntity<List<LaundrySuppliesInfoAndStoreIdAndTotalSalesProjectionDTO>> getLaundrySuppliesSalesCountTop5ByStoreIdAndYearAndMonth(@RequestParam Long storeId,
                                                                                                                                               @RequestParam Integer year,
                                                                                                                                               @RequestParam Integer month) {
        log.info("getLaundrySuppliesSalesCountTop5ByStoreIdAndYearAndMonth : storeId = {}, year = {}, month = {}", storeId, year, month);
        return new ResponseEntity<>(laundrySuppliesService.getLaundrySuppliesSalesCountTop5ByStoreIdAndYearAndMonth(storeId, year, month), HttpStatus.OK);
    }

    @GetMapping
    @Operation()
    public ResponseEntity<>
}