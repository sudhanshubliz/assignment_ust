# Day 3 - Employee & Department Microservices

Assignment: Employee Department Information System.

## Services

| Service | Port | API |
| --- | --- | --- |
| Department Service | `8081` | `GET /departments/{id}` |
| Employee Service | `8082` | `GET /employees/{id}` |

## Run Department Service

```bash
cd department-service
mvn spring-boot:run
```

## Run Employee Service

Open another terminal:

```bash
cd employee-service
mvn spring-boot:run
```

## Test APIs

Department Service:

```bash
curl http://localhost:8081/departments/101
```

Employee Service:

```bash
curl http://localhost:8082/employees/1
```

Expected employee response:

```json
{
  "employeeId": 1,
  "employeeName": "Rahul",
  "departmentName": "Engineering",
  "location": "Bangalore",
  "managerName": "Ananya Sharma"
}
```

The Employee Service calls the Department Service and returns a combined HRMS-style response.
