package com.ust.capstone.order.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private String productName;
    private Integer quantity;
    private String status;

    public CustomerOrder() {
    }

    public CustomerOrder(Long userId, String productName, Integer quantity, String status) {
        this.userId = userId;
        this.productName = productName;
        this.quantity = quantity;
        this.status = status;
    }

    public Long getId() { return id; }
    public Long getUserId() { return userId; }
    public String getProductName() { return productName; }
    public Integer getQuantity() { return quantity; }
    public String getStatus() { return status; }
}
