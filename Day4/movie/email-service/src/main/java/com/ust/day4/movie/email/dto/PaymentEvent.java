package com.ust.day4.movie.email.dto;

public record PaymentEvent(Integer bookingId, String status) {
}
