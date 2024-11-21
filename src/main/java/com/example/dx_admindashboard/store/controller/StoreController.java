package com.example.dx_admindashboard.store.controller;

import com.example.dx_admindashboard.store.domain.dto.StoreDTO;
import com.example.dx_admindashboard.store.service.StoreService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/get/one")
    @Operation(summary = "Get One Store", description = "매장 가져오기")
    public ResponseEntity<StoreDTO> getStore() {
        log.info("getStore");
        return new ResponseEntity<>(storeService.getStore(), HttpStatus.OK);
    }

}
