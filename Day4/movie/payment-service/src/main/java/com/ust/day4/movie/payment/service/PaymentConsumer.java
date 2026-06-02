package com.ust.day4.movie.payment.service;

import com.ust.day4.movie.payment.dto.BookingEvent;
import com.ust.day4.movie.payment.dto.PaymentEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PaymentConsumer {
    private final KafkaTemplate<String, PaymentEvent> kafkaTemplate;

    public PaymentConsumer(KafkaTemplate<String, PaymentEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @KafkaListener(topics = "booking-events", groupId = "payment-service-group")
    public void consume(BookingEvent event) {
        System.out.println("Payment Initiated");
        kafkaTemplate.send("payment-events", String.valueOf(event.bookingId()),
                new PaymentEvent(event.bookingId(), "PAYMENT_INITIATED"));
    }
}
