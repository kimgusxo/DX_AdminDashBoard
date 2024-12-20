package com.example.dx_admindashboard.entity.kiosk.mealkit.service;

import com.example.dx_admindashboard.entity.kiosk.mealkit.domain.dto.MealKitCounterDTO;
import com.example.dx_admindashboard.entity.kiosk.mealkit.repository.MealKitCounterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MealKitCounterService {

    private final MealKitCounterRepository mealKitCounterRepository;

    public Integer fetchMealKitCounter(MealKitCounterDTO mealKitCounterDTO) {
        return mealKitCounterRepository.updateMealKitCounter(mealKitCounterDTO);
    }
}
