package com.example.dx_admindashboard.user.service;

import com.example.dx_admindashboard.user.domain.dto.UserDTO;
import com.example.dx_admindashboard.user.domain.dto.join.MealKitInfoAndTotalSalesAndStoreIdByUserFeaturesProjectionDTO;
import com.example.dx_admindashboard.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public List<UserDTO> getUserListByStoreId(Long storeId) {
    }

    @Transactional
    public List<MealKitInfoAndTotalSalesAndStoreIdByUserFeaturesProjectionDTO> getMealKitSalesCountTop5ByUserGender(Long storeId,
                                                                                                                    String userGender) {
    }

    @Transactional
    public List<MealKitInfoAndTotalSalesAndStoreIdByUserFeaturesProjectionDTO> getMealKitSalesCountTop5ByUserAge(Long storeId,
                                                                                                                 Integer userAge) {
    }
}
