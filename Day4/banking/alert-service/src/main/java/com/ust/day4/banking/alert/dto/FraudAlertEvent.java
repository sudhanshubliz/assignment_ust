package com.ust.day4.banking.alert.dto;

public record FraudAlertEvent(Integer transactionId, Double amount, String message) {
}
