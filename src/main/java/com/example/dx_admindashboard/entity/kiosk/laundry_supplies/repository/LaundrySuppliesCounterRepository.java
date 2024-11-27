package com.example.dx_admindashboard.entity.kiosk.laundry_supplies.repository;

import com.example.dx_admindashboard.entity.kiosk.laundry_supplies.domain.LaundrySuppliesCounter;
import com.example.dx_admindashboard.entity.kiosk.laundry_supplies.domain.dto.LaundrySuppliesCounterDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LaundrySuppliesCounterRepository extends JpaRepository<LaundrySuppliesCounter, Long> {

    @Modifying
    @Query("""
        UPDATE LaundrySuppliesCounter lsc
        SET lsc.laundrySuppliesCount = :#{#lscd.laundrySuppliesCount}
        WHERE lsc.laundrySupplies.laundrySuppliesId = :#{#lscd.laundrySuppliesId}
        AND lsc.store.storeId = :#{#lscd.storeId}
        """)
    Integer updateLaundrySuppliesCounter(@Param("lscd") LaundrySuppliesCounterDTO lscd);


    Optional<LaundrySuppliesCounter> findByLaundrySupplies_LaundrySuppliesIdAndStore_StoreId(Long laundrySuppliesIdLong, Long storeId);
}
