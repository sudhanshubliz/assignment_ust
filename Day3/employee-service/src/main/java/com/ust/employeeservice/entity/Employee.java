package com.ust.employeeservice.entity;

public class Employee {
    private Long employeeId;
    private String employeeName;
    private Long departmentId;

    public Employee(Long employeeId, String employeeName, Long departmentId) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.departmentId = departmentId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public Long getDepartmentId() {
        return departmentId;
    }
}
