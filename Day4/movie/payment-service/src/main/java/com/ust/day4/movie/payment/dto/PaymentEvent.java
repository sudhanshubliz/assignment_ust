package com.ust.day4.movie.payment.dto;

public record PaymentEvent(Integer bookingId, String status) {
}
