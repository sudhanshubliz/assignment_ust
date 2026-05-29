package com.ust.employeeservice.controller;

import com.ust.employeeservice.dto.EmployeeDepartmentResponse;
import com.ust.employeeservice.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable Long id) {
        try {
            return employeeService.getEmployeeWithDepartment(id)
                    .<ResponseEntity<?>>map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                            .body("Employee not found with id: " + id));
        } catch (IllegalStateException exception) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                    .body(exception.getMessage());
        }
    }
}
