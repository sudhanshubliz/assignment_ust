package com.ust.day4.banking.alert.service;

import com.ust.day4.banking.alert.dto.FraudAlertEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class AlertConsumer {

    @KafkaListener(topics = "fraud-alerts", groupId = "alert-service-group")
    public void consume(FraudAlertEvent event) {
        System.out.println("Notification Service Alert : " + event.message()
                + " for transaction " + event.transactionId());
    }
}
