package com.example.dx_admindashboard.entity.kiosk.mealkit.controller;

import com.example.dx_admindashboard.entity.kiosk.mealkit.domain.dto.MealKitCounterDTO;
import com.example.dx_admindashboard.entity.kiosk.mealkit.service.MealKitCounterService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/mealKitCounter")
@RequiredArgsConstructor
public class MealKitCounterController {

    private final MealKitCounterService mealKitCounterService;

    @Operation(summary = "Update MealKitCounter", description = "밀키트 재고 업데이트")
    @PutMapping("/update/count")
    public ResponseEntity<Integer> fetchMealKitCounter(@RequestBody MealKitCounterDTO mealKitCounterDTO) {
        log.info("fetchMealKitCounter : mealKitCounterDTO = {}", mealKitCounterDTO);
        return new ResponseEntity<>(mealKitCounterService.fetchMealKitCounter(mealKitCounterDTO), HttpStatus.OK);
    }


}
