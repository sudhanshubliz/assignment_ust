package com.ust.studentmanagement.controller;

import com.ust.studentmanagement.entity.Student;
import com.ust.studentmanagement.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> addStudent(@RequestBody Student student) {
        Student savedStudent = studentService.addStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response("Student added successfully", savedStudent));
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(response("Students fetched successfully", students));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id)
                .map(student -> ResponseEntity.ok(response("Student found successfully", student)))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(response("Student not found with id: " + id, null)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateStudent(
            @PathVariable Long id,
            @RequestBody Student student
    ) {
        return studentService.updateStudent(id, student)
                .map(updatedStudent -> ResponseEntity.ok(response("Student updated successfully", updatedStudent)))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(response("Student not found with id: " + id, null)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteStudent(@PathVariable Long id) {
        if (studentService.deleteStudent(id)) {
            return ResponseEntity.ok(response("Student deleted successfully", null));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(response("Student not found with id: " + id, null));
    }

    private Map<String, Object> response(String message, Object data) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", message);
        response.put("data", data);
        return response;
    }
}
