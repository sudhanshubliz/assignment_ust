package com.ust.day4.movie.booking.service;

import com.ust.day4.movie.booking.dto.BookingEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class BookingProducerService {
    private final KafkaTemplate<String, BookingEvent> kafkaTemplate;

    public BookingProducerService(KafkaTemplate<String, BookingEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publish(BookingEvent event) {
        kafkaTemplate.send("booking-events", String.valueOf(event.bookingId()), event);
    }
}
