
package com.example.employee_service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeControllerTest {

    private EmployeeManager employeeManager;
    private EmployeeController employeeController;

    @BeforeEach
    void setUp() {
        employeeManager = new EmployeeManager();
        employeeController = new EmployeeController(employeeManager);
    }

    @Test
    void shouldReturnEmployeesOnGet() {
        Employees employees = employeeController.getAllEmployees();

        assertEquals(4, employees.getEmployeeList().size());
        assertEquals(
            "101",
            employees.getEmployeeList().get(0).getEmployeeId()
        );
    }

    @Test
    void shouldAddEmployeeOnPost() {
        Employee employee = new Employee(
            "105",
            "Neha",
            "Singh",
            "neha@example.com",
            "Backend Developer"
        );

        ResponseEntity<Void> response =
            employeeController.addEmployee(employee);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());

        Employees employees = employeeManager.getEmployees();

        assertEquals(5, employees.getEmployeeList().size());
        assertEquals(
            "105",
            employees.getEmployeeList().get(4).getEmployeeId()
        );
    }
}
