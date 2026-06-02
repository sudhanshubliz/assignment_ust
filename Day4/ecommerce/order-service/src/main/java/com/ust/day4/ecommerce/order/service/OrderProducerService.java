package com.ust.day4.ecommerce.order.service;

import com.ust.day4.ecommerce.order.dto.Order;
import com.ust.day4.ecommerce.order.dto.OrderStatusEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderProducerService {
    private static final String ORDER_EVENTS_TOPIC = "order-events";
    private static final String ORDER_STATUS_TOPIC = "order-status";

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public OrderProducerService(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publish(Order order) {
        kafkaTemplate.send(ORDER_EVENTS_TOPIC, String.valueOf(order.orderId()), order);
    }

    public void publishStatus(OrderStatusEvent event) {
        kafkaTemplate.send(ORDER_STATUS_TOPIC, String.valueOf(event.orderId()), event);
    }
}
