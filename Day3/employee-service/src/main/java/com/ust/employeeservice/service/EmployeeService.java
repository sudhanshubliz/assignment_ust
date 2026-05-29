package com.ust.employeeservice.service;

import com.ust.employeeservice.dto.DepartmentResponse;
import com.ust.employeeservice.dto.EmployeeDepartmentResponse;
import com.ust.employeeservice.entity.Employee;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.Optional;

@Service
public class EmployeeService {
    private final RestTemplate restTemplate;
    private final String departmentServiceUrl;

    private final Map<Long, Employee> employees = Map.of(
            1L, new Employee(1L, "Rahul", 101L),
            2L, new Employee(2L, "Priya", 102L),
            3L, new Employee(3L, "Arjun", 103L)
    );

    public EmployeeService(
            RestTemplate restTemplate,
            @Value("${department.service.url}") String departmentServiceUrl
    ) {
        this.restTemplate = restTemplate;
        this.departmentServiceUrl = departmentServiceUrl;
    }

    public Optional<EmployeeDepartmentResponse> getEmployeeWithDepartment(Long id) {
        Employee employee = employees.get(id);

        if (employee == null) {
            return Optional.empty();
        }

        DepartmentResponse department = fetchDepartment(employee.getDepartmentId());

        return Optional.of(new EmployeeDepartmentResponse(
                employee.getEmployeeId(),
                employee.getEmployeeName(),
                department.getDepartmentName(),
                department.getLocation(),
                department.getManagerName()
        ));
    }

    private DepartmentResponse fetchDepartment(Long departmentId) {
        String url = departmentServiceUrl + "/departments/" + departmentId;

        try {
            return restTemplate.getForObject(url, DepartmentResponse.class);
        } catch (RestClientException exception) {
            throw new IllegalStateException("Department Service is unavailable or department was not found", exception);
        }
    }
}
