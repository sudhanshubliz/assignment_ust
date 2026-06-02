package com.ust.day4.banking.transaction.service;

import com.ust.day4.banking.transaction.dto.TransactionEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class TransactionProducerService {
    private final KafkaTemplate<String, TransactionEvent> kafkaTemplate;

    public TransactionProducerService(KafkaTemplate<String, TransactionEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publish(TransactionEvent event) {
        kafkaTemplate.send("transaction-events", String.valueOf(event.transactionId()), event);
    }
}
