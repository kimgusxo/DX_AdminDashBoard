package com.example.dx_admindashboard.order.repository;

import com.example.dx_admindashboard.order.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    // Main 페이지 1번
    List<Order> findAll();
    Order findByOrderId(Long orderId);

    // Main 페이지 2번은 통신 X

    // Main 페이지 3번



}
