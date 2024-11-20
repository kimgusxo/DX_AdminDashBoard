package com.example.dx_admindashboard.home_appliances.repository;

import com.example.dx_admindashboard.home_appliances.domain.HomeAppliances;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HomeAppliancesRepository extends JpaRepository<HomeAppliances, Integer> {

    // 가전 페이지 1번
    @Query("""
            SELECT ha
            FROM HomeAppliances ha
            JOIN ha.homeAppliancesStateList has
            WHERE has.store.storeId = :storeId
            """)
    List<HomeAppliances> findHomeAppliancesByStoreId(Long storeId);

    // 가전 페이지 2번
    @Query("""
            SELECT ha
            FROM HomeAppliances ha
            JOIN ha.homeAppliancesStateList has
            WHERE has.store.storeId = :storeId
            AND has.homeAppliancesState = :state
            """)
    List<HomeAppliances> findHomeAppliancesByStoreIdAndHomeAppliancesState(Long storeId, String state);
}
