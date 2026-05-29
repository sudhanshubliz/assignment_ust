package com.ust.departmentservice.controller;

import com.ust.departmentservice.dto.DepartmentResponse;
import com.ust.departmentservice.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDepartmentById(@PathVariable Long id) {
        return departmentService.getDepartmentById(id)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new DepartmentResponse(id, "Department not found", "", "")));
    }
}
