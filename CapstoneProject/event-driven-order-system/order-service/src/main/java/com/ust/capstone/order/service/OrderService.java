package com.ust.capstone.order.service;

import com.ust.capstone.order.dto.CreateOrderRequest;
import com.ust.capstone.order.dto.OrderEvent;
import com.ust.capstone.order.dto.OrderResponse;
import com.ust.capstone.order.kafka.OrderEventProducer;
import com.ust.capstone.order.model.CustomerOrder;
import com.ust.capstone.order.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderEventProducer producer;

    public OrderService(OrderRepository orderRepository, OrderEventProducer producer) {
        this.orderRepository = orderRepository;
        this.producer = producer;
    }

    public OrderResponse createOrder(CreateOrderRequest request) {
        CustomerOrder order = orderRepository.save(new CustomerOrder(
                request.userId(),
                request.productName(),
                request.quantity(),
                "CREATED"
        ));

        producer.publish(new OrderEvent(
                order.getId(),
                order.getUserId(),
                order.getProductName(),
                order.getQuantity(),
                order.getStatus()
        ));

        return toResponse(order);
    }

    public List<OrderResponse> getOrders() {
        return orderRepository.findAll().stream().map(this::toResponse).toList();
    }

    public Optional<OrderResponse> getOrder(Long id) {
        return orderRepository.findById(id).map(this::toResponse);
    }

    private OrderResponse toResponse(CustomerOrder order) {
        return new OrderResponse(
                order.getId(),
                order.getUserId(),
                order.getProductName(),
                order.getQuantity(),
                order.getStatus()
        );
    }
}
