package com.example.dx_admindashboard.home_appliances.repository;

import com.example.dx_admindashboard.home_appliances.domain.HomeAppliances;
import com.example.dx_admindashboard.home_appliances.domain.projection.HomeAppliancesInfoAndStoreIdProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HomeAppliancesRepository extends JpaRepository<HomeAppliances, Integer> {

    // 가전 페이지 1번
    @Query("""
            SELECT ha.homeAppliancesId AS homeAppliancesId, 
                   ha.homeAppliancesClassification AS homeAppliancesClassification, 
                   ha.homeAppliancesName AS homeAppliancesName, 
                   ha.homeAppliancesModelName AS homeAppliancesModelName, 
                   has.store.storeId AS storeId
            FROM HomeAppliances ha
            JOIN HomeAppliancesState has ON ha.homeAppliancesId = has.homeAppliances.homeAppliancesId
            WHERE has.store.storeId = :storeId
            """)
    List<HomeAppliancesInfoAndStoreIdProjection> findHomeAppliancesByStoreId(@Param("storeId") Long storeId);

    // 가전 페이지 2번
    @Query("""
            SELECT ha.homeAppliancesId AS homeAppliancesId, 
                   ha.homeAppliancesClassification AS homeAppliancesClassification, 
                   ha.homeAppliancesName AS homeAppliancesName, 
                   ha.homeAppliancesModelName AS homeAppliancesModelName, 
                   has.store.storeId AS storeId
            FROM HomeAppliances ha
            JOIN HomeAppliancesState has ON ha.homeAppliancesId = has.homeAppliances.homeAppliancesId
            WHERE has.store.storeId = :storeId
            AND has.homeAppliancesState = :homeAppliancesState
            """)
    List<HomeAppliancesInfoAndStoreIdProjection> findHomeAppliancesByStoreIdAndHomeAppliancesState(@Param("storeId") Long storeId,
                                                                                               @Param("homeAppliancesState") String homeAppliancesState);
}
