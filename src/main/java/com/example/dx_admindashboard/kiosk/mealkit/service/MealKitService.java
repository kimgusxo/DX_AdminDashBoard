package com.example.dx_admindashboard.kiosk.mealkit.service;

import com.example.dx_admindashboard.kiosk.mealkit.repository.MealKitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MealKitService {

    private final MealKitRepository mealKitRepository;

}
