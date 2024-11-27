package com.example.dx_admindashboard.entity.kiosk.mealkit.repository;

import com.example.dx_admindashboard.entity.kiosk.mealkit.domain.MealKitOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealKitOrderRepository extends JpaRepository<MealKitOrder, Long> {
}
