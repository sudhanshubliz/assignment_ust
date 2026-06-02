package com.ust.day4.ecommerce.inventory.service;

import com.ust.day4.ecommerce.inventory.dto.Order;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class InventoryConsumer {

    @KafkaListener(topics = "order-events", groupId = "inventory-group")
    public void consume(Order order) {
        System.out.println("Inventory Updated : " + order.product() + " for order " + order.orderId());
    }
}
