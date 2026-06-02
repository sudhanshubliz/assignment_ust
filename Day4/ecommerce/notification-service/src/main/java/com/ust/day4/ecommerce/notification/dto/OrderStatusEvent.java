package com.ust.day4.ecommerce.notification.dto;

public record OrderStatusEvent(Integer orderId, String status) {
}
