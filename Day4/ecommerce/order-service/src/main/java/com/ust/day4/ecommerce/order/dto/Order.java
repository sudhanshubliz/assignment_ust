package com.ust.day4.ecommerce.order.dto;

public record Order(Integer orderId, String product, Double amount) {
}
