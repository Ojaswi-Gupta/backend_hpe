
package com.example.employee_service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeManagerTest {

    private EmployeeManager employeeManager;

    @BeforeEach
    void setUp() {
        // Create a real manager before every test.
        employeeManager = new EmployeeManager();
    }

    @Test
    void shouldInitializeFourEmployees() {
        Employees employees = employeeManager.getEmployees();

        assertEquals(4, employees.getEmployeeList().size());
    }

    @Test
    void shouldAddNewEmployee() {
        Employee employee = new Employee(
            "105",
            "Neha",
            "Singh",
            "neha@example.com",
            "Backend Developer"
        );

        employeeManager.addEmployee(employee);

        Employees employees = employeeManager.getEmployees();
        assertEquals(5, employees.getEmployeeList().size());

        Employee addedEmployee = employees.getEmployeeList().get(4);

        assertEquals("105", addedEmployee.getEmployeeId());
        assertEquals("Neha", addedEmployee.getFirstName());
        assertEquals("Singh", addedEmployee.getLastName());
        assertEquals("neha@example.com", addedEmployee.getEmail());
        assertEquals("Backend Developer", addedEmployee.getTitle());
    }
}
