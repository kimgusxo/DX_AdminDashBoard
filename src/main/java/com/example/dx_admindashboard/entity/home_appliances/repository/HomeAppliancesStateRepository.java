package com.example.dx_admindashboard.entity.home_appliances.repository;

import com.example.dx_admindashboard.entity.home_appliances.domain.HomeAppliancesState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeAppliancesStateRepository extends JpaRepository<HomeAppliancesState, Long> {



}
