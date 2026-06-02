package com.ust.day4.ecommerce.order.controller;

import com.ust.day4.ecommerce.order.dto.Order;
import com.ust.day4.ecommerce.order.dto.OrderStatusEvent;
import com.ust.day4.ecommerce.order.service.OrderProducerService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderProducerService producer;

    public OrderController(OrderProducerService producer) {
        this.producer = producer;
    }

    @PostMapping("/{id}")
    public String createOrder(@PathVariable Integer id) {
        producer.publish(new Order(id, "Laptop", 50000.0));
        return "Order Event Published";
    }

    @PostMapping
    public String createOrderWithJson(@RequestBody Order order) {
        producer.publish(order);
        return "Order Event Published";
    }

    @PostMapping("/{id}/status")
    public String updateOrderStatus(@PathVariable Integer id, @RequestParam String status) {
        producer.publishStatus(new OrderStatusEvent(id, status));
        return "Order Status Event Published";
    }
}
