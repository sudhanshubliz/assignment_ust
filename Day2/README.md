# Day 2 - Student Management CRUD API

Spring Boot REST API assignment for managing students.

## Run

```bash
mvn spring-boot:run
```

## APIs

| API | Method | Description |
| --- | --- | --- |
| `/students` | `POST` | Add a student |
| `/students` | `GET` | Get all students |
| `/students/{id}` | `GET` | Get student by ID |
| `/students/{id}` | `PUT` | Update student |
| `/students/{id}` | `DELETE` | Delete student |

## Sample Request

```json
{
  "name": "Sudhanshu",
  "course": "Java Spring Boot",
  "marks": 90
}
```
