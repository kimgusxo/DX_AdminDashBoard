package com.example.dx_admindashboard.entity.store.controller;

import com.example.dx_admindashboard.entity.store.domain.dto.StoreDTO;
import com.example.dx_admindashboard.entity.store.service.StoreService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/store")
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;

    @GetMapping("/get/list")
    @Operation(summary = "Get StoreList", description = "매장 리스트 가져오기")
    public ResponseEntity<List<StoreDTO>> getStoreList() {
        log.info("getStoreList");
        return new ResponseEntity<>(storeService.getStoreList(), HttpStatus.OK);
    }

    @GetMapping("/get/one/{storeId}")
    @Operation(summary = "Get One Store", description = "매장 가져오기")
    public ResponseEntity<StoreDTO> getStore(@PathVariable Long storeId) {
        log.info("getStore");
        return new ResponseEntity<>(storeService.getStore(storeId), HttpStatus.OK);
    }

}
