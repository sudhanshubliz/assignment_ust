package com.ust.day4.banking.transaction.controller;

import com.ust.day4.banking.transaction.dto.TransactionEvent;
import com.ust.day4.banking.transaction.service.TransactionProducerService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    private final TransactionProducerService producer;

    public TransactionController(TransactionProducerService producer) {
        this.producer = producer;
    }

    @PostMapping("/{id}")
    public TransactionEvent createTransaction(@PathVariable Integer id, @RequestParam(defaultValue = "75000") Double amount) {
        TransactionEvent event = new TransactionEvent(id, amount);
        producer.publish(event);
        return event;
    }
}
