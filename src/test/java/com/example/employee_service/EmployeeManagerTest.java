
package com.example.employee_service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeManagerTest {

    private EmployeeManager employeeManager;

    @BeforeEach
    void setUp() {
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

        assertEquals(
            5,
            employeeManager.getEmployees().getEmployeeList().size()
        );

        assertEquals(
            "105",
            employeeManager.getEmployees()
                .getEmployeeList()
                .get(4)
                .getEmployeeId()
        );
    }
}
