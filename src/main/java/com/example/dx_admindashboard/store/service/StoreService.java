package com.example.dx_admindashboard.store.service;

import com.example.dx_admindashboard.store.domain.dto.StoreDTO;
import com.example.dx_admindashboard.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;


    @Transactional
    public List<StoreDTO> getStoreList() {
    }

    @Transactional
    public StoreDTO getStore() {
    }
}
