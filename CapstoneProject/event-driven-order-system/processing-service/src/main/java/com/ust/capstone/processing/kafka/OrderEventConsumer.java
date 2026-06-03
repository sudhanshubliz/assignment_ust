package com.ust.capstone.processing.kafka;

import com.ust.capstone.processing.dto.OrderEvent;
import com.ust.capstone.processing.service.OrderProcessingService;
import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

@Service
public class OrderEventConsumer {
    private final OrderProcessingService processingService;

    public OrderEventConsumer(OrderProcessingService processingService) {
        this.processingService = processingService;
    }

    @RetryableTopic(attempts = "3")
    @KafkaListener(topics = "order-events", groupId = "processing-group")
    public void consume(OrderEvent event, Acknowledgment acknowledgment) {
        processingService.process(event);
        acknowledgment.acknowledge();
    }

    @DltHandler
    public void handleDeadLetter(OrderEvent event) {
        System.out.println("Dead Letter Topic handling for order " + event.orderId());
    }
}
