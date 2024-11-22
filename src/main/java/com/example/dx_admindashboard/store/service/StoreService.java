package com.example.dx_admindashboard.store.service;

import com.example.dx_admindashboard.exception.ListEmptyException;
import com.example.dx_admindashboard.store.domain.Store;
import com.example.dx_admindashboard.store.domain.dto.StoreDTO;
import com.example.dx_admindashboard.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;


    @Transactional
    public List<StoreDTO> getStoreList() {
        List<Store> results = storeRepository.findAll();

        if (results.isEmpty()) {
            throw new ListEmptyException();
        }

        List<StoreDTO> resultsDTO = new ArrayList<>();

        results.forEach(r -> {
            resultsDTO.add(StoreDTO.from(r));
        });

        return resultsDTO;
    }

    @Transactional
    public StoreDTO getStore(Long storeId) {
        return StoreDTO.from(storeRepository.findByStoreId(storeId));
    }
}
