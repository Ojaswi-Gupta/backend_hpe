
package com.example.employee_service;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Employees {

    private List<Employee> employeeList = new ArrayList<>();

    public Employees() {
    }

    @JsonProperty("Employees")
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
