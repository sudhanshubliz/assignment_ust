package com.ust.capstone.order.dto;

public record CreateOrderRequest(Long userId, String productName, Integer quantity) {
}
