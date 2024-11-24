package com.example.dx_admindashboard.entity.user.controller;

import com.example.dx_admindashboard.entity.user.domain.dto.UserDTO;
import com.example.dx_admindashboard.entity.user.domain.dto.join.MealKitInfoAndTotalSalesAndStoreIdByUserFeaturesProjectionDTO;
import com.example.dx_admindashboard.entity.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/get/list/{storeId}")
    @Operation(summary = "Get UserList", description = "매장 별 사용 고객 리스트 가져오기")
    public ResponseEntity<List<UserDTO>> getUserListByStoreId(@PathVariable Long storeId) {
        log.info("getUserListByStoreId : {}", storeId);
        return new ResponseEntity<>(userService.getUserListByStoreId(storeId), HttpStatus.OK);
    }

    @GetMapping("/get/list/gender")
    @Operation(summary = "Get UserLists By UserGender", description = "매장 별 성별 별 밀키트 판매량 TOP 5")
    public ResponseEntity<List<MealKitInfoAndTotalSalesAndStoreIdByUserFeaturesProjectionDTO>> getMealKitSalesCountTop5ByUserGender(@RequestParam Long storeId,
                                                                                                                                    @RequestParam String userGender) {
        log.info("getMealKitSalesCountTop5ByUserGender : storeId = {}, userGender = {}", storeId, userGender);
        return new ResponseEntity<>(userService.getMealKitSalesCountTop5ByUserGender(storeId, userGender), HttpStatus.OK);
    }

    @GetMapping("/get/list/age")
    @Operation(summary = "Get UserLists By UserAge", description = "매장 별 연령 별 밀키트 판매량 TOP 5")
    public ResponseEntity<List<MealKitInfoAndTotalSalesAndStoreIdByUserFeaturesProjectionDTO>> getMealKitSalesCountTop5ByUserAge(@RequestParam Long storeId,
                                                                                                                                 @RequestParam Integer userAge) {
        log.info("getMealKitSalesCountTop5ByUserAge : storeId = {}, userAge = {}", storeId, userAge);
        return new ResponseEntity<>(userService.getMealKitSalesCountTop5ByUserAge(storeId, userAge), HttpStatus.OK);
    }


}
