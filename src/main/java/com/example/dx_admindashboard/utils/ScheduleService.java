package com.example.dx_admindashboard.utils;

import com.example.dx_admindashboard.entity.kiosk.laundry_supplies.domain.LaundrySupplies;
import com.example.dx_admindashboard.entity.kiosk.laundry_supplies.domain.LaundrySuppliesCounter;
import com.example.dx_admindashboard.entity.kiosk.laundry_supplies.domain.LaundrySuppliesOrder;
import com.example.dx_admindashboard.entity.kiosk.laundry_supplies.repository.LaundrySuppliesCounterRepository;
import com.example.dx_admindashboard.entity.kiosk.laundry_supplies.repository.LaundrySuppliesOrderRepository;
import com.example.dx_admindashboard.entity.kiosk.laundry_ticket.LaundryTicketOrderRepository;
import com.example.dx_admindashboard.entity.kiosk.laundry_ticket.domain.LaundryTicket;
import com.example.dx_admindashboard.entity.kiosk.laundry_ticket.domain.LaundryTicketOrder;
import com.example.dx_admindashboard.entity.kiosk.mealkit.domain.MealKit;
import com.example.dx_admindashboard.entity.kiosk.mealkit.domain.MealKitCounter;
import com.example.dx_admindashboard.entity.kiosk.mealkit.domain.MealKitOrder;
import com.example.dx_admindashboard.entity.kiosk.mealkit.repository.MealKitCounterRepository;
import com.example.dx_admindashboard.entity.kiosk.mealkit.repository.MealKitOrderRepository;
import com.example.dx_admindashboard.entity.order.domain.Order;
import com.example.dx_admindashboard.entity.order.repository.OrderRepository;
import com.example.dx_admindashboard.entity.store.domain.Store;
import com.example.dx_admindashboard.entity.user.domain.User;
import com.example.dx_admindashboard.exception.FirebaseException;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

/*
 * 12시에 업데이트 하는 기능은 진짜 모든 것이 개발 완료되었을 때
 * 리팩토링 하는걸로
 * 합시다.
 */
@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final Firestore db;
    private final MealKitCounterRepository mealKitCounterRepository;
    private final LaundrySuppliesCounterRepository laundrySuppliesCounterRepository;
    private final OrderRepository orderRepository;
    private final MealKitOrderRepository mealKitOrderRepository;
    private final LaundrySuppliesOrderRepository laundrySuppliesOrderRepository;
    private final LaundryTicketOrderRepository laundryTicketOrderRepository;

    // 마지막 동기화 시간을 저장
    private static LocalDateTime lastSyncTime = LocalDateTime.now().minusDays(1);


    /**
     * 스케줄링: 매일 밤 12시에 Firestore에서 재고 데이터를 가져와 업데이트
     */
    @Scheduled(cron = "0 0 0 * * ?")
    @Transactional
    public void updateInventoryFromFirestore() {
        try {
            // 밀키트 재고 업데이트
            updateMealKitInventory();

            // 세탁용품 재고 업데이트
            updateLaundrySuppliesInventory();

        } catch (Exception e) {
            throw new FirebaseException();
        }
    }

    /**
     * Firestore에서 밀키트 재고 데이터를 가져와 데이터베이스에 업데이트
     */
    private void updateMealKitInventory() throws Exception {
        QuerySnapshot mealKitSnapshot = db.collection("stores_meal_kits_count").get().get();

        mealKitSnapshot.getDocuments().forEach(document -> {
            Long storeId = Long.valueOf(document.getId());
            Map<String, Object> mealKitsCount = (Map<String, Object>) document.get("meal_kits_count");

            mealKitsCount.forEach((mealKitKey, data) -> {
                Map<String, Object> mealKitData = (Map<String, Object>) data;

                Long mealKitId = Long.valueOf((String) mealKitData.get("meal_kit_id")); // Long 타입으로 변환
                Integer mealKitCount = ((Long) mealKitData.get("meal_kit_count")).intValue(); // Integer로 변환

                mealKitCounterRepository.findByMealKit_MealKitIdAndStore_StoreId(mealKitId, storeId)
                        .ifPresentOrElse(
                                mealKitCounter -> {
                                    mealKitCounter.setMealKitCount(mealKitCount);
                                    mealKitCounterRepository.save(mealKitCounter);
                                },
                                () -> {
                                    MealKitCounter newCounter = MealKitCounter.builder()
                                            .mealKit(MealKit.builder().mealKitId(mealKitId).build())
                                            .store(Store.builder().storeId(storeId).build())
                                            .mealKitCount(mealKitCount)
                                            .build();
                                    mealKitCounterRepository.save(newCounter);
                                }
                        );
            });
        });
    }

    /**
     * Firestore에서 세탁용품 재고 데이터를 가져와 데이터베이스에 업데이트
     */
    private void updateLaundrySuppliesInventory() throws Exception {
        QuerySnapshot laundrySuppliesSnapshot = db.collection("stores_laundry_supplies_count").get().get();

        laundrySuppliesSnapshot.getDocuments().forEach(document -> {
            Long storeId = Long.valueOf(document.getId());
            Map<String, Object> laundrySuppliesCount = (Map<String, Object>) document.get("laundry_supplies_count");

            laundrySuppliesCount.forEach((laundrySuppliesKey, data) -> {
                Map<String, Object> laundrySuppliesData = (Map<String, Object>) data;

                Long laundrySuppliesId = Long.valueOf((String) laundrySuppliesData.get("laundry_supplies_id")); // Long 타입으로 변환
                Integer laundrySuppliesCountValue = ((Long) laundrySuppliesData.get("laundry_supplies_count")).intValue(); // Integer로 변환

                laundrySuppliesCounterRepository.findByLaundrySupplies_LaundrySuppliesIdAndStore_StoreId(laundrySuppliesId, storeId)
                        .ifPresentOrElse(
                                laundrySuppliesCounter -> {
                                    laundrySuppliesCounter.setLaundrySuppliesCount(laundrySuppliesCountValue.toString());
                                    laundrySuppliesCounterRepository.save(laundrySuppliesCounter);
                                },
                                () -> {
                                    LaundrySuppliesCounter newCounter = LaundrySuppliesCounter.builder()
                                            .laundrySupplies(LaundrySupplies.builder().laundrySuppliesId(laundrySuppliesId).build())
                                            .store(Store.builder().storeId(storeId).build())
                                            .laundrySuppliesCount(laundrySuppliesCountValue.toString())
                                            .build();
                                    laundrySuppliesCounterRepository.save(newCounter);
                                }
                        );
            });
        });
    }

    @Scheduled(cron = "0 0 0 * * ?")
    @Transactional
    public void syncOrdersFromFirestore() {
        try {
            // ISO 8601 포맷으로 변환된 마지막 동기화 시간
            String lastSyncTimeString = lastSyncTime.format(DateTimeFormatter.ISO_DATE_TIME);

            // Firestore에서 마지막 동기화 이후 데이터 가져오기
            QuerySnapshot ordersSnapshot = db.collection("orders")
                    .whereGreaterThan("order_time", lastSyncTimeString)
                    .get()
                    .get();

            ordersSnapshot.getDocuments().forEach(document -> {
                Long orderId = Long.valueOf(document.getId());
                Map<String, Object> orderData = document.getData();

                // Order 기본 데이터 매핑
                Order order = orderRepository.findById(orderId).orElse(Order.builder().build());
                order.setOrderId(orderId);
                order.setUser(User.builder().userId(Long.valueOf((String) orderData.get("user_id"))).build());
                order.setStore(Store.builder().storeId(Long.valueOf((String) orderData.get("store_id"))).build());
                order.setSpaceIsUsed((Boolean) orderData.get("space_is_used"));
                order.setOrderTotalPrice(((Long) orderData.get("order_total_price")).intValue());
                order.setOrderTime(LocalDateTime.parse((String) orderData.get("order_time")));

                Order savedOrder = orderRepository.save(order); // Order 저장

                // MealKitOrder 처리
                Map<String, Object> mealKitsOrder = (Map<String, Object>) orderData.get("meal_kits_order");
                if (mealKitsOrder != null) {
                    mealKitsOrder.forEach((mealKitKey, data) -> {
                        Map<String, Object> mealKitData = (Map<String, Object>) data;
                        MealKitOrder mealKitOrder = MealKitOrder.builder()
                                .mealKit(MealKit.builder().mealKitId(Long.valueOf((String) mealKitData.get("meal_kit_id"))).build())
                                .order(savedOrder)
                                .build();
                        mealKitOrderRepository.save(mealKitOrder);
                    });
                }

                // LaundrySuppliesOrder 처리
                Map<String, Object> laundrySuppliesOrder = (Map<String, Object>) orderData.get("laundry_supplies_order");
                if (laundrySuppliesOrder != null) {
                    laundrySuppliesOrder.forEach((suppliesKey, data) -> {
                        Map<String, Object> suppliesData = (Map<String, Object>) data;
                        LaundrySuppliesOrder laundrySuppliesOrderEntity = LaundrySuppliesOrder.builder()
                                .laundrySupplies(LaundrySupplies.builder().laundrySuppliesId(Long.valueOf((String) suppliesData.get("laundry_supplies_id"))).build())
                                .order(savedOrder)
                                .build();
                        laundrySuppliesOrderRepository.save(laundrySuppliesOrderEntity);
                    });
                }

                // LaundryTicketOrder 처리
                Map<String, Object> laundryTicketsUsed = (Map<String, Object>) orderData.get("laundry_tickets_used");
                if (laundryTicketsUsed != null) {
                    laundryTicketsUsed.forEach((ticketKey, data) -> {
                        Map<String, Object> ticketData = (Map<String, Object>) data;
                        LaundryTicketOrder laundryTicketOrder = LaundryTicketOrder.builder()
                                .laundryTicket(LaundryTicket.builder().laundryTicketId(Long.valueOf((String) ticketData.get("laundry_ticket_id"))).build())
                                .order(savedOrder)
                                .build();
                        laundryTicketOrderRepository.save(laundryTicketOrder);
                    });
                }
            });

            // 마지막 동기화 시간 갱신
            lastSyncTime = LocalDateTime.now();

        } catch (Exception e) {
            throw new FirebaseException();
        }
    }
}
