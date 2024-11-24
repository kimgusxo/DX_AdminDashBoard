package com.example.dx_admindashboard.entity.store.repository;

import com.example.dx_admindashboard.entity.store.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StoreRepository extends JpaRepository<Store, Long> {

    // Main 페이지 1번
    List<Store> findAll();
    Optional<Store> findByStoreId(Long storeId);

}
