package com.ust.departmentservice.dto;

public class DepartmentResponse {
    private Long departmentId;
    private String departmentName;
    private String location;
    private String managerName;

    public DepartmentResponse() {
    }

    public DepartmentResponse(Long departmentId, String departmentName, String location, String managerName) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.location = location;
        this.managerName = managerName;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
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
