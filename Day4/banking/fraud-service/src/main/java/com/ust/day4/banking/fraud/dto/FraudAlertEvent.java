package com.ust.day4.banking.fraud.dto;

public record FraudAlertEvent(Integer transactionId, Double amount, String message) {
}
