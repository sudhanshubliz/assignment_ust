package com.ust.capstone.user.kafka;

import com.ust.capstone.user.dto.OrderStatusEvent;
import com.ust.capstone.user.service.UserService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

@Service
public class UserNotificationConsumer {
    private final UserService userService;

    public UserNotificationConsumer(UserService userService) {
        this.userService = userService;
    }

    @KafkaListener(topics = "order-status-events", groupId = "user-notification-group")
    public void consume(OrderStatusEvent event, Acknowledgment acknowledgment) {
        userService.saveNotification(event);
        System.out.println("Order " + event.orderId() + " " + event.status());
        acknowledgment.acknowledge();
    }
}
