package com.example.employee_service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class EmployeeManager {

    private final Employees employees;

    public EmployeeManager() {
        employees = new Employees();

        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee("101", "Aarav", "Sharma","aarav@example.com", "Software Engineer"));
        employeeList.add(new Employee("102", "Priya", "Verma","priya@example.com", "Data Analyst"));
        employeeList.add(new Employee("103", "Rahul", "Patel","rahul@example.com", "Project Manager"));
        employeeList.add(new Employee("104", "Ananya", "Rao","ananya@example.com", "HR Manager"));

        employees.setEmployeeList(employeeList);
    }

    public Employees getEmployees() {
        return employees;
    }

    public void addEmployee(Employee employee) {
        employees.getEmployeeList().add(employee);
    }
}