package com.example.dx_admindashboard.entity.kiosk.laundry_supplies.controller;

import com.example.dx_admindashboard.entity.kiosk.laundry_supplies.domain.dto.LaundrySuppliesCounterDTO;
import com.example.dx_admindashboard.entity.kiosk.laundry_supplies.service.LaundrySuppliesCounterService;
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
@RequestMapping("/laundrySuppliesCounter")
@RequiredArgsConstructor
public class LaundrySuppliesCounterController {

    private final LaundrySuppliesCounterService laundrySuppliesCounterService;

    @Operation(summary = "Update LaundrySuppliesCounter", description = "세탁용품 재고 업데이트")
    @PutMapping
    public ResponseEntity<Integer> fetchLaundrySuppliesCounter(@RequestBody LaundrySuppliesCounterDTO laundrySuppliesCounterDTO) {
        log.info("fetchLaundrySuppliesCounter : laundrySuppliesCounterDTO = {}", laundrySuppliesCounterDTO);
        return new ResponseEntity<>(laundrySuppliesCounterService.fetchLaundrySuppliesCounter(laundrySuppliesCounterDTO), HttpStatus.OK);
    }
}
