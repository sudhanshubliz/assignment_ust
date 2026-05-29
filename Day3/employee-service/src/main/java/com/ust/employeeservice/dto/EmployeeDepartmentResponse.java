package com.ust.employeeservice.dto;

public class EmployeeDepartmentResponse {
    private Long employeeId;
    private String employeeName;
    private String departmentName;
    private String location;
    private String managerName;

    public EmployeeDepartmentResponse() {
    }

    public EmployeeDepartmentResponse(
            Long employeeId,
            String employeeName,
            String departmentName,
            String location,
            String managerName
    ) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.departmentName = departmentName;
        this.location = location;
        this.managerName = managerName;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }
}
