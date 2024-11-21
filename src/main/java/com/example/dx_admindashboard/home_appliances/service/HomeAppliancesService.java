package com.example.dx_admindashboard.home_appliances.service;

import com.example.dx_admindashboard.home_appliances.repository.HomeAppliancesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HomeAppliancesService {

    private HomeAppliancesRepository homeAppliancesRepository;


}
