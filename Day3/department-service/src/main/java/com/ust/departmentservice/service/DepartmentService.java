package com.ust.departmentservice.service;

import com.ust.departmentservice.dto.DepartmentResponse;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class DepartmentService {
    private final Map<Long, DepartmentResponse> departments = Map.of(
            101L, new DepartmentResponse(101L, "Engineering", "Bangalore", "Ananya Sharma"),
            102L, new DepartmentResponse(102L, "Human Resources", "Hyderabad", "Meera Nair"),
            103L, new DepartmentResponse(103L, "Finance", "Chennai", "Vikram Rao")
    );

    public Optional<DepartmentResponse> getDepartmentById(Long id) {
        return Optional.ofNullable(departments.get(id));
    }
}
