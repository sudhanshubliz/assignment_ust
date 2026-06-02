package com.ust.day4.movie.booking.dto;

public record BookingEvent(Integer bookingId, String movie, String seat) {
}
