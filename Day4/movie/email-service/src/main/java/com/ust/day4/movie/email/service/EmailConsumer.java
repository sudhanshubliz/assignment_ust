package com.ust.day4.movie.email.service;

import com.ust.day4.movie.email.dto.PaymentEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class EmailConsumer {

    @KafkaListener(topics = "payment-events", groupId = "email-service-group")
    public void consume(PaymentEvent event) {
        System.out.println("Email Sent for booking " + event.bookingId());
    }
}
