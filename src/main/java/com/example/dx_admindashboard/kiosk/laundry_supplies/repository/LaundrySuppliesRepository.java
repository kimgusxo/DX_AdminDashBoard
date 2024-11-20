package com.example.dx_admindashboard.kiosk.laundry_supplies.repository;

import com.example.dx_admindashboard.kiosk.laundry_supplies.domain.LaundrySupplies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaundrySuppliesRepository extends JpaRepository<LaundrySupplies, Long> {



}
