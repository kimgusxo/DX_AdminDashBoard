package com.example.dx_admindashboard.order.domain.dto;

import com.example.dx_admindashboard.order.domain.Order;

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
        return new OrderDTO(orderId, userId,storeId, spaceIsUsed, orderTotalPrice, orderTime);
    }
    public static OrderDTO from(Order order) {
        return new OrderDTO(
                order.getOrderId(),
                order.getUserId(),
                order.getStoreId(),
                order.getSpaceIsUsed(),
                order.getOrderTotalPrice(),
                order.getOrderTime()
        );
    }
    public Order toEntity() {
        return Order.builder()
                .orderId(orderId)
                .userId(userId)
                .storeId(storeId)
                .spaceIsUsed(spaceIsUsed)
                .orderTotalPrice(orderTotalPrice)
                .orderTime(orderTime)
                .build();
    }
}