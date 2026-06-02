package com.ust.day4.banking.fraud.service;

import com.ust.day4.banking.fraud.dto.FraudAlertEvent;
import com.ust.day4.banking.fraud.dto.TransactionEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class FraudDetectionConsumer {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public FraudDetectionConsumer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @KafkaListener(topics = "transaction-events", groupId = "fraud-detection-group")
    public void consume(TransactionEvent event) {
        if (event.amount() > 50000) {
            System.out.println("Fraud Alert");
            FraudAlertEvent alert = new FraudAlertEvent(
                    event.transactionId(),
                    event.amount(),
                    "Potential Fraud"
            );
            kafkaTemplate.send("fraud-alerts", String.valueOf(event.transactionId()), alert);
        }
    }
}
