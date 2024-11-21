package com.example.dx_admindashboard.home_appliances.service;

import com.example.dx_admindashboard.exception.ListEmptyException;
import com.example.dx_admindashboard.home_appliances.domain.dto.join.HomeAppliancesInfoAndStoreIdProjectionDTO;
import com.example.dx_admindashboard.home_appliances.domain.projection.HomeAppliancesInfoAndStoreIdProjection;
import com.example.dx_admindashboard.home_appliances.repository.HomeAppliancesRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HomeAppliancesService {

    private HomeAppliancesRepository homeAppliancesRepository;

    @Transactional
    public List<HomeAppliancesInfoAndStoreIdProjectionDTO> getHomeAppliancesListByStoreId(Long storeId) {
        List<HomeAppliancesInfoAndStoreIdProjection> results =
                homeAppliancesRepository.findHomeAppliancesListByStoreId(storeId);

        if (results.isEmpty()) {
            throw new ListEmptyException();
        }

        List<HomeAppliancesInfoAndStoreIdProjectionDTO> resultsDTO = new ArrayList<>();

        results.forEach(r -> {
            resultsDTO.add(HomeAppliancesInfoAndStoreIdProjectionDTO.from(r));
        });

        return resultsDTO;
    }

    @Transactional
    public List<HomeAppliancesInfoAndStoreIdProjectionDTO> getHomeAppliancesListByStoreIdAndHomeAppliancesState(Long storeId,
                                                                                                                String homeAppliancesState) {
        List<HomeAppliancesInfoAndStoreIdProjection> results =
                homeAppliancesRepository.findHomeAppliancesListByStoreIdAndHomeAppliancesState(storeId, homeAppliancesState);

        if (results.isEmpty()) {
            throw new ListEmptyException();
        }

        List<HomeAppliancesInfoAndStoreIdProjectionDTO> resultsDTO = new ArrayList<>();

        results.forEach(r -> {
            resultsDTO.add(HomeAppliancesInfoAndStoreIdProjectionDTO.from(r));
        });

        return resultsDTO;
    }
}
