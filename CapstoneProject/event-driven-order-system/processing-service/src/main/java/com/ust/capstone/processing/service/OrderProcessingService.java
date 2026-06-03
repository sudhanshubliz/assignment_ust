package com.ust.capstone.processing.service;

import com.ust.capstone.processing.dto.OrderEvent;
import com.ust.capstone.processing.dto.OrderStatusEvent;
import com.ust.capstone.processing.kafka.OrderStatusProducer;
import org.springframework.stereotype.Service;

@Service
public class OrderProcessingService {
    private final OrderStatusProducer producer;

    public OrderProcessingService(OrderStatusProducer producer) {
        this.producer = producer;
    }

    public void process(OrderEvent event) {
        if ("FAIL".equalsIgnoreCase(event.productName())) {
            throw new IllegalStateException("Simulated processing failure for retry and DLT demo");
        }

        boolean approved = event.quantity() <= 5;
        String status = approved ? "APPROVED" : "REJECTED";
        String message = approved
                ? "Order validated and inventory check passed"
                : "Order rejected because quantity is greater than 5";

        OrderStatusEvent statusEvent = new OrderStatusEvent(
                event.orderId(),
                event.userId(),
                status,
                message
        );

        producer.publish(statusEvent);
        System.out.println("Order " + event.orderId() + " " + status);
    }
}
