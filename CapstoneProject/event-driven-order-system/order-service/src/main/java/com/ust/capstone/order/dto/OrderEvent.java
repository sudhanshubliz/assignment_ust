package com.ust.capstone.order.dto;

public record OrderEvent(Long orderId, Long userId, String productName, Integer quantity, String status) {
}
