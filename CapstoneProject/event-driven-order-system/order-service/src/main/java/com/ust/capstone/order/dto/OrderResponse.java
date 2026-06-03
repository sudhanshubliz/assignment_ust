package com.ust.capstone.order.dto;

public record OrderResponse(Long orderId, Long userId, String productName, Integer quantity, String status) {
}
