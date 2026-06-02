# Day 4 - Kafka Enterprise Assignments

This folder contains three Kafka-based enterprise examples.

## Start Kafka

```bash
docker compose up -d
```

Kafka UI:

```text
http://localhost:8080
```

## Assignment 1 - E-Commerce Order Notification System

Services:

| Service | Port | Purpose |
| --- | --- | --- |
| `ecommerce/order-service` | `8081` | Publishes `order-events` and `order-status` |
| `ecommerce/notification-service` | `8082` | Consumes order events and status events |
| `ecommerce/inventory-service` | `8083` | Consumes order events with a different group |

Run each service in a separate terminal:

```bash
mvn -pl ecommerce/order-service spring-boot:run
mvn -pl ecommerce/notification-service spring-boot:run
mvn -pl ecommerce/inventory-service spring-boot:run
```

Test:

```bash
curl -X POST http://localhost:8081/orders/101
curl -X POST http://localhost:8081/orders -H "Content-Type: application/json" -d '{"orderId":102,"product":"Laptop","amount":50000}'
curl -X POST "http://localhost:8081/orders/101/status?status=ORDER_DELIVERED"
```

Topics are created automatically:

- `order-events`
- `order-status`

## Assignment 2 - Banking Transaction Monitoring System

Services:

| Service | Port | Purpose |
| --- | --- | --- |
| `banking/transaction-service` | `8091` | Publishes `transaction-events` |
| `banking/fraud-service` | `8092` | Consumes transactions, publishes fraud alerts |
| `banking/alert-service` | `8093` | Consumes `fraud-alerts` |

Run:

```bash
mvn -pl banking/transaction-service spring-boot:run
mvn -pl banking/fraud-service spring-boot:run
mvn -pl banking/alert-service spring-boot:run
```

Test:

```bash
curl -X POST "http://localhost:8091/transactions/101?amount=75000"
```

Expected fraud service console:

```text
Fraud Alert
```

## Assignment 3 - Movie Ticket Booking System

Services:

| Service | Port | Purpose |
| --- | --- | --- |
| `movie/booking-service` | `8101` | Publishes `booking-events` |
| `movie/payment-service` | `8102` | Consumes bookings and publishes `payment-events` |
| `movie/email-service` | `8103` | Consumes payment events |

Run:

```bash
mvn -pl movie/booking-service spring-boot:run
mvn -pl movie/payment-service spring-boot:run
mvn -pl movie/email-service spring-boot:run
```

Test:

```bash
curl -X POST http://localhost:8101/bookings/101
```

Expected payment service console:

```text
Payment Initiated
```
