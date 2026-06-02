package com.ust.day4.ecommerce.notification.service;

import com.ust.day4.ecommerce.notification.dto.Order;
import com.ust.day4.ecommerce.notification.dto.OrderStatusEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumer {

    @KafkaListener(topics = "order-events", groupId = "notification-group")
    public void consume(Order order) {
        System.out.println("Notification Sent : " + order);
    }

    @KafkaListener(
            topics = "order-status",
            groupId = "notification-status-group",
            containerFactory = "orderStatusKafkaListenerContainerFactory"
    )
    public void consumeStatus(OrderStatusEvent event) {
        if ("ORDER_DELIVERED".equals(event.status())) {
            System.out.println("Order Delivered");
            return;
        }

        System.out.println("Order Status Updated : " + event.status());
    }
}
