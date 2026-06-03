package com.ust.capstone.processing.dto;

public record OrderEvent(Long orderId, Long userId, String productName, Integer quantity, String status) {
}
