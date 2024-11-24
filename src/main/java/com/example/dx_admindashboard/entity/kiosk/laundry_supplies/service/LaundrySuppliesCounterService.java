package com.example.dx_admindashboard.entity.kiosk.laundry_supplies.service;

import com.example.dx_admindashboard.entity.kiosk.laundry_supplies.domain.dto.LaundrySuppliesCounterDTO;
import com.example.dx_admindashboard.entity.kiosk.laundry_supplies.repository.LaundrySuppliesCounterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LaundrySuppliesCounterService {

    private final LaundrySuppliesCounterRepository laundrySuppliesCounterRepository;

    @Transactional
    public Integer fetchLaundrySuppliesCounter(LaundrySuppliesCounterDTO laundrySuppliesCounterDTO) {
        return laundrySuppliesCounterRepository.updateLaundrySuppliesCounter(laundrySuppliesCounterDTO);
    }
}
