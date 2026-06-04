# Capstone Project - Event-Driven Order Processing System

Production-style Java microservices capstone using Spring Boot 3, Java 17, H2, and Apache Kafka.

## Architecture

```text
User Service
     |
     v
Order Service -- publishes --> order-events
                                |
                                v
                        Processing Service
                                |
                                v
                     order-status-events
                                |
                                v
                          User Service
```

## Services

| Service | Port | Responsibility |
| --- | --- | --- |
| `user-service` | `9001` | Create/get users and receive order status notifications |
| `order-service` | `9002` | Accept/store orders and publish `order-events` |
| `processing-service` | `9003` | Consume orders, validate quantity, publish `order-status-events` |

## Kafka Topics

| Topic | Partitions | Replicas | Purpose |
| --- | ---: | ---: | --- |
| `order-events` | 3 | 1 | Order created events |
| `order-status-events` | 3 | 1 | Approved/rejected order status events |

Retry and DLT topics are created automatically by `@RetryableTopic`.

## Run Locally

Start Kafka and Kafka UI:

```bash
docker compose up -d zookeeper kafka kafka-ui
```

Run services in separate terminals:

```bash
mvn -pl user-service spring-boot:run
mvn -pl order-service spring-boot:run
mvn -pl processing-service spring-boot:run
```

Kafka UI:

```text
http://localhost:8080
```

## Swagger Documentation

Each microservice exposes its own Swagger UI, categorized by service:

| Service | Swagger UI | OpenAPI JSON |
| --- | --- | --- |
| User Service | `http://localhost:9001/swagger-ui/index.html` | `http://localhost:9001/v3/api-docs` |
| Order Service | `http://localhost:9002/swagger-ui/index.html` | `http://localhost:9002/v3/api-docs` |
| Processing Service | `http://localhost:9003/swagger-ui/index.html` | `http://localhost:9003/v3/api-docs` |

## API Demo

Create user:

```bash
curl -X POST http://localhost:9001/users \
  -H "Content-Type: application/json" \
  -d '{"name":"John","email":"john@test.com"}'
```

Create approved order:

```bash
curl -X POST http://localhost:9002/orders \
  -H "Content-Type: application/json" \
  -d '{"userId":1,"productName":"Laptop","quantity":1}'
```

Create rejected order:

```bash
curl -X POST http://localhost:9002/orders \
  -H "Content-Type: application/json" \
  -d '{"userId":1,"productName":"Monitor","quantity":7}'
```

Trigger retry and dead-letter handling:

```bash
curl -X POST http://localhost:9002/orders \
  -H "Content-Type: application/json" \
  -d '{"userId":1,"productName":"FAIL","quantity":1}'
```

Get user notifications:

```bash
curl http://localhost:9001/users/1/notifications
```

## Health Checks

```bash
curl http://localhost:9001/actuator/health
curl http://localhost:9002/actuator/health
curl http://localhost:9003/actuator/health
```

