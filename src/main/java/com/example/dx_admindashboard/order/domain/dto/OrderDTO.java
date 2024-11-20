package com.example.dx_admindashboard.order.domain.dto;

import com.example.dx_admindashboard.order.domain.Order;
import com.example.dx_admindashboard.store.domain.Store;
import com.example.dx_admindashboard.user.domain.User;

import java.time.LocalDateTime;

public record OrderDTO(
        Long orderId,
        Long userId,
        Long storeId,
        Boolean spaceIsUsed,
        Integer orderTotalPrice,
        LocalDateTime orderTime
) {
    public static OrderDTO of(Long orderId,
                              Long userId,
                              Long storeId,
                              Boolean spaceIsUsed,
                              Integer orderTotalPrice,
                              LocalDateTime orderTime) {
        return new OrderDTO(orderId, userId, storeId, spaceIsUsed, orderTotalPrice, orderTime);
    }

    public static OrderDTO from(Order order) {
        return new OrderDTO(
                order.getOrderId(),
                order.getUser().getUserId(), // User의 ID 추출
                order.getStore().getStoreId(), // Store의 ID 추출
                order.getSpaceIsUsed(),
                order.getOrderTotalPrice(),
                order.getOrderTime()
        );
    }

    public Order toEntity() {
        return Order.builder()
                .orderId(orderId)
                .user(User.builder().userId(userId).build()) // ID로 User 엔티티 생성
                .store(Store.builder().storeId(storeId).build()) // ID로 Store 엔티티 생성
                .spaceIsUsed(spaceIsUsed)
                .orderTotalPrice(orderTotalPrice)
                .orderTime(orderTime)
                .build();
    }
}
