package com.ust.capstone.user.repository;

import com.ust.capstone.user.model.OrderNotification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderNotificationRepository extends JpaRepository<OrderNotification, Long> {
    List<OrderNotification> findByUserIdOrderByCreatedAtDesc(Long userId);
}
