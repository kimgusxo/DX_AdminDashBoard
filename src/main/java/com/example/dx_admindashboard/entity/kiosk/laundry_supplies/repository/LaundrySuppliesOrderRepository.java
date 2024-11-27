package com.example.dx_admindashboard.entity.kiosk.laundry_supplies.repository;

import com.example.dx_admindashboard.entity.kiosk.laundry_supplies.domain.LaundrySuppliesOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaundrySuppliesOrderRepository extends JpaRepository<LaundrySuppliesOrder, Long> {
}
