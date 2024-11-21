package com.example.dx_admindashboard.user.service;

import com.example.dx_admindashboard.exception.ListEmptyException;
import com.example.dx_admindashboard.user.domain.User;
import com.example.dx_admindashboard.user.domain.dto.UserDTO;
import com.example.dx_admindashboard.user.domain.dto.join.MealKitInfoAndTotalSalesAndStoreIdByUserFeaturesProjectionDTO;
import com.example.dx_admindashboard.user.domain.projection.MealKitInfoAndTotalSalesAndStoreIdByUserFeaturesProjection;
import com.example.dx_admindashboard.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public List<UserDTO> getUserListByStoreId(Long storeId) {
        List<User> results = userRepository.findUserListByStoreId(storeId);

        if(results.isEmpty()) {
            throw new ListEmptyException();
        }

        List<UserDTO> resultsDTO = new ArrayList<>();

        results.forEach(r -> {
            resultsDTO.add(UserDTO.from(r));
        });

        return resultsDTO;
    }

    @Transactional
    public List<MealKitInfoAndTotalSalesAndStoreIdByUserFeaturesProjectionDTO> getMealKitSalesCountTop5ByUserGender(Long storeId,
                                                                                                                    String userGender) {
        List<MealKitInfoAndTotalSalesAndStoreIdByUserFeaturesProjection> results =
                userRepository.findMealKitSalesCountTop5ByUserGender(storeId, userGender);

        if(results.isEmpty()) {
            throw new ListEmptyException();
        }

        List<MealKitInfoAndTotalSalesAndStoreIdByUserFeaturesProjectionDTO> resultsDTO = new ArrayList<>();

        results.forEach(r -> {
           resultsDTO.add(MealKitInfoAndTotalSalesAndStoreIdByUserFeaturesProjectionDTO.from(r));
        });

        return resultsDTO;
    }

    @Transactional
    public List<MealKitInfoAndTotalSalesAndStoreIdByUserFeaturesProjectionDTO> getMealKitSalesCountTop5ByUserAge(Long storeId,
                                                                                                                 Integer userAge) {
        List<MealKitInfoAndTotalSalesAndStoreIdByUserFeaturesProjection> results =
                userRepository.findMealKitSalesCountTop5ByUserAge(storeId, userAge);

        if(results.isEmpty()) {
            throw new ListEmptyException();
        }

        List<MealKitInfoAndTotalSalesAndStoreIdByUserFeaturesProjectionDTO> resultsDTO = new ArrayList<>();

        results.forEach(r -> {
            resultsDTO.add(MealKitInfoAndTotalSalesAndStoreIdByUserFeaturesProjectionDTO.from(r));
        });

        return resultsDTO;
    }
}
