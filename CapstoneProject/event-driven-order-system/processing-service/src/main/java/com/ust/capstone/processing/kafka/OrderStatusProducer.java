package com.ust.capstone.processing.kafka;

import com.ust.capstone.processing.dto.OrderStatusEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderStatusProducer {
    private static final String TOPIC = "order-status-events";
    private final KafkaTemplate<String, OrderStatusEvent> kafkaTemplate;

    public OrderStatusProducer(KafkaTemplate<String, OrderStatusEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publish(OrderStatusEvent event) {
        kafkaTemplate.send(TOPIC, String.valueOf(event.orderId()), event);
    }
}
