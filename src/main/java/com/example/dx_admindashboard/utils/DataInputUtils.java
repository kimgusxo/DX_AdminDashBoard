package com.example.dx_admindashboard.utils;

import com.example.dx_admindashboard.entity.home_appliances.repository.HomeAppliancesStateRepository;
import com.example.dx_admindashboard.entity.kiosk.laundry_supplies.repository.LaundrySuppliesCounterRepository;
import com.example.dx_admindashboard.entity.kiosk.mealkit.repository.MealKitCounterRepository;
import com.example.dx_admindashboard.exception.FirebaseException;
import com.google.cloud.firestore.Firestore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class DataInputUtils {

    private final Firestore db;
    private final MealKitCounterRepository mealKitCounterRepository;
    private final LaundrySuppliesCounterRepository laundrySuppliesCounterRepository;
    private final HomeAppliancesStateRepository homeAppliancesStateRepository;

    @Transactional
    public void loadDbToFirestore() {
        try {
            // 매장별 밀키트 재고 저장
            mealKitCounterRepository.findAll().forEach(mealKitCounter -> {
                Long storeId = mealKitCounter.getStore().getStoreId();
                Long mealKitId = mealKitCounter.getMealKit().getMealKitId();

                // 상위 컬렉션 문서에 store_id 추가
                db.collection("stores_meal_kits_count")
                        .document(String.valueOf(storeId))
                        .set(Map.of(
                                "store_id", storeId // 상위 문서에 store_id 추가
                        ));

                // 하위 컬렉션에 meal_kit 정보 추가
                db.collection("stores_meal_kits_count")
                        .document(String.valueOf(storeId))
                        .collection("meal_kits_count")
                        .document(String.valueOf(mealKitId))
                        .set(Map.of(
                                "meal_kit_id", mealKitId,
                                "meal_kit_count", mealKitCounter.getMealKitCount()
                        ));
            });

            // 매장별 세탁용품 재고 저장
            laundrySuppliesCounterRepository.findAll().forEach(laundrySuppliesCounter -> {
                Long storeId = laundrySuppliesCounter.getStore().getStoreId();
                Long laundrySuppliesId = laundrySuppliesCounter.getLaundrySupplies().getLaundrySuppliesId();

                // 상위 컬렉션 문서에 store_id 추가
                db.collection("stores_laundry_supplies_count")
                        .document(String.valueOf(storeId))
                        .set(Map.of(
                                "store_id", storeId // 상위 문서에 store_id 추가
                        ));

                // 하위 컬렉션에 laundry_supplies 정보 추가
                db.collection("stores_laundry_supplies_count")
                        .document(String.valueOf(storeId))
                        .collection("laundry_supplies_count")
                        .document(String.valueOf(laundrySuppliesId))
                        .set(Map.of(
                                "laundry_supplies_id", laundrySuppliesId,
                                "laundry_supplies_count", Integer.valueOf(laundrySuppliesCounter.getLaundrySuppliesCount())
                        ));
            });

            // 매장별 가전 상태 저장
            homeAppliancesStateRepository.findAll().forEach(homeAppliancesState -> {
                Long storeId = homeAppliancesState.getStore().getStoreId();
                Long homeAppliancesId = homeAppliancesState.getHomeAppliances().getHomeAppliancesId();

                // 상위 컬렉션 문서에 store_id 추가
                db.collection("stores_appliances_state")
                        .document(String.valueOf(storeId))
                        .set(Map.of(
                                "store_id", storeId // 상위 문서에 store_id 추가
                        ));

                // 하위 컬렉션에 home_appliances 상태 추가
                db.collection("stores_appliances_state")
                        .document(String.valueOf(storeId))
                        .collection("home_appliances_state")
                        .document(String.valueOf(homeAppliancesId))
                        .set(Map.of(
                                "home_appliances_id", homeAppliancesId,
                                "home_appliances_position", homeAppliancesState.getHomeAppliancesPosition(),
                                "home_appliances_state", homeAppliancesState.getHomeAppliancesState()
                        ));
            });

        } catch (Exception e) {
            throw new FirebaseException();
        }
    }
}

