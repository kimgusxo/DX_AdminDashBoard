package com.example.dx_admindashboard.store.repository;

import com.example.dx_admindashboard.store.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoreRepository extends JpaRepository<Store, Long> {

    // Main 페이지 1번
    List<Store> findAll();
    Store findByStoreId(Long storeId);

}