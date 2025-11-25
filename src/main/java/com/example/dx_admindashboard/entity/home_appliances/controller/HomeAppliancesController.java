package com.example.dx_admindashboard.entity.home_appliances.controller;

import com.example.dx_admindashboard.entity.home_appliances.domain.dto.join.HomeAppliancesInfoAndStoreIdProjectionDTO;
import com.example.dx_admindashboard.entity.home_appliances.service.HomeAppliancesService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/homeAppliances")
@RequiredArgsConstructor
public class HomeAppliancesController {

    private final HomeAppliancesService homeAppliancesService;

    @GetMapping
    @Operation(summary = "Get HomeAppliancesList", description = "매장 별 가전 리스트 가져오기")
    public ResponseEntity<List<HomeAppliancesInfoAndStoreIdProjectionDTO>> getHomeAppliancesListByStoreId(@RequestParam Long storeId) {
        log.info("getHomeAppliancesListByStoreId : storeId = {}", storeId);
        return new ResponseEntity<>(homeAppliancesService.getHomeAppliancesListByStoreId(storeId), HttpStatus.OK);
    }

    @GetMapping("/state")
    @Operation(summary = "Get HomeAppliancesList By HomeAppliancesState", description = "매장 별 고장난 상태의 가전 리스트 가져오기")
    public ResponseEntity<List<HomeAppliancesInfoAndStoreIdProjectionDTO>> getHomeAppliancesListByStoreIdAndHomeAppliancesState(@RequestParam Long storeId,
                                                                                                                                @RequestParam String homeAppliancesState) {
        log.info("getHomeAppliancesListByStoreIdAndHomeAppliancesState : storeId = {}, homeAppliancesState = {}", storeId, homeAppliancesState);
        return new ResponseEntity<>(homeAppliancesService.getHomeAppliancesListByStoreIdAndHomeAppliancesState(storeId, homeAppliancesState), HttpStatus.OK);

    }
}
