package com.example.dx_admindashboard.entity.kiosk.laundry_ticket;

import com.example.dx_admindashboard.entity.kiosk.laundry_ticket.domain.LaundryTicketOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaundryTicketOrderRepository extends JpaRepository<LaundryTicketOrder, Long> {
}
