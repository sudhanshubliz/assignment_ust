package com.ust.day4.movie.booking.controller;

import com.ust.day4.movie.booking.dto.BookingEvent;
import com.ust.day4.movie.booking.service.BookingProducerService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    private final BookingProducerService producer;

    public BookingController(BookingProducerService producer) {
        this.producer = producer;
    }

    @PostMapping("/{id}")
    public BookingEvent bookTicket(@PathVariable Integer id) {
        BookingEvent event = new BookingEvent(id, "Avengers", "A12");
        producer.publish(event);
        return event;
    }

    @PostMapping
    public BookingEvent bookTicketWithJson(@RequestBody BookingEvent event) {
        producer.publish(event);
        return event;
    }
}
