package com.ust.day4.ecommerce.order.dto;

public record OrderStatusEvent(Integer orderId, String status) {
}
