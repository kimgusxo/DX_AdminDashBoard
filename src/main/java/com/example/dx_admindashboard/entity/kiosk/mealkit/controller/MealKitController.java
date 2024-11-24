package com.example.dx_admindashboard.entity.kiosk.mealkit.controller;

import com.example.dx_admindashboard.entity.kiosk.mealkit.domain.dto.join.MealKitInfoAndStoreIdAndMealKitCountProjectionDTO;
import com.example.dx_admindashboard.entity.kiosk.mealkit.domain.dto.join.MealKitInfoAndStoreIdAndMonthlyTotalRevenueProjectionDTO;
import com.example.dx_admindashboard.entity.kiosk.mealkit.domain.dto.join.MealKitInfoAndStoreIdAndTotalSalesProjectionDTO;
import com.example.dx_admindashboard.entity.kiosk.mealkit.domain.dto.join.MonthAndSalesCountAndStoreIdByMealKitIdAndYearProjectionDTO;
import com.example.dx_admindashboard.entity.kiosk.mealkit.service.MealKitService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/mealKit")
@RequiredArgsConstructor
public class MealKitController {

    private final MealKitService mealKitService;

    @GetMapping("/get/list/{storeId}")
    @Operation(summary = "Get MealKitList", description = "매장 별 밀키트 리스트 가져오기")
    public ResponseEntity<List<MealKitInfoAndStoreIdAndMealKitCountProjectionDTO>> getMealKitListByStoreId(@PathVariable Long storeId) {
        log.info("getMealKitListByStoreId : storeId = {}", storeId);
        return new ResponseEntity<>(mealKitService.getMealKitListByStoreId(storeId), HttpStatus.OK);
    }

    @GetMapping("/get/one/month/count")
    @Operation(summary = "Get MealKitSalesCount By MealKitId And Year", description = "매장 별 밀키트별 해당 연도의 월별 판매량")
    public ResponseEntity<List<MonthAndSalesCountAndStoreIdByMealKitIdAndYearProjectionDTO>> getMealKitSalesCountByMealKitIdAndStoreIdAndYear(@RequestParam Long mealKitId,
                                                                                                                                              @RequestParam Long storeId,
                                                                                                                                              @RequestParam Integer year) {
        log.info("getMealKitSalesCountByMealKitIdAndStoreIdAndYear : mealKitId = {}, storeId = {}, year = {}", mealKitId, storeId, year);
        return new ResponseEntity<>(mealKitService.getMealKitSalesCountByMealKitIdAndStoreIdAndYear(mealKitId, storeId, year), HttpStatus.OK);
    }

    @GetMapping("/get/top5/year/count")
    @Operation(summary = "Get MealKitSalesCountTop5 By Year", description = "매장 별 밀키트 연도별 판매량 TOP 5")
    public ResponseEntity<List<MealKitInfoAndStoreIdAndTotalSalesProjectionDTO>> getMealKitSalesCountTop5ByStoreIdAndYear(@RequestParam Long storeId,
                                                                                                                          @RequestParam Integer year) {
        log.info("getMealKitSalesCountTop5ByStoreIdAndYear : storeId = {}, year = {}", storeId, year);
        return new ResponseEntity<>(mealKitService.getMealKitSalesCountTop5ByStoreIdAndYear(storeId, year), HttpStatus.OK);
    }

    @GetMapping("/get/top5/month/count")
    @Operation(summary = "Get MealKitSalesCountTop5 By Year And Month", description = "매장 별 밀키트 해당 연도의 월별 판매량 TOP 5")
    public ResponseEntity<List<MealKitInfoAndStoreIdAndTotalSalesProjectionDTO>> getMealKitSalesCountTop5ByStoreIdAndYearAndMonth(@RequestParam Long storeId,
                                                                             @RequestParam Integer year,
                                                                             @RequestParam Integer month) {
        log.info("getMealKitSalesCountTop5ByStoreIdAndYearAndMonth : storeId = {}, year = {}, month = {}", storeId, year, month);
        return new ResponseEntity<>(mealKitService.getMealKitSalesCountTop5ByStoreIdAndYearAndMonth(storeId, year, month), HttpStatus.OK);
    }

    @GetMapping("/get/top5/month/revenue")
    @Operation(summary = "Get MealKitSalesRevenueTop5 By Year And Month", description = "매장 별 밀키트 해당 연도의 월별 매출량 TOP 5")
    public ResponseEntity<List<MealKitInfoAndStoreIdAndMonthlyTotalRevenueProjectionDTO>> getMealKitSalesRevenueTop5ByStoreIdAndYearAndMonth(@RequestParam Long storeId,
                                                                                                                                             @RequestParam Integer year,
                                                                                                                                             @RequestParam Integer month) {
        log.info("getMealKitSalesRevenueTop5ByStoreIdAndYearAndMonth : storeId = {}, year = {}, month = {}", storeId, year, month);
        return new ResponseEntity<>(mealKitService.getMealKitSalesRevenueTop5ByStoreIdAndYearAndMonth(storeId, year, month), HttpStatus.OK);
    }

    @GetMapping("/get/top5/count")
    @Operation(summary = "Get MealKitSalesCountTop5", description = "매장 별 밀키트 전체기간 판매량 TOP 5")
    public ResponseEntity<List<MealKitInfoAndStoreIdAndTotalSalesProjectionDTO>> getMealKitSalesCountTop5ByStoreId(@RequestParam Long storeId) {
        log.info("getMealKitSalesCountTop5ByStoreId : storeId = {}", storeId);
        return new ResponseEntity<>(mealKitService.getMealKitSalesCountTop5ByStoreId(storeId), HttpStatus.OK);
    }


}
