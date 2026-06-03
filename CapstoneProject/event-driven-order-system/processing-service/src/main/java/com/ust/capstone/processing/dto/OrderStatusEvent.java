package com.ust.capstone.processing.dto;

public record OrderStatusEvent(Long orderId, Long userId, String status, String message) {
}
