
package com.example.employee_service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeControllerTest {

    @Mock
    private EmployeeManager employeeManager;

    @InjectMocks
    private EmployeeController employeeController;

    private Employees sampleEmployees;

    @BeforeEach
    void setUp() {
        // Prepare predictable data for the controller tests.
        sampleEmployees = new Employees();

        sampleEmployees.getEmployeeList().add(
            new Employee(
                "101",
                "Aarav",
                "Sharma",
                "aarav@example.com",
                "Software Engineer"
            )
        );
    }

    @Test
    void shouldReturnEmployeesOnGet() {
        // Arrange: tell the mock what to return.
        when(employeeManager.getEmployees()).thenReturn(sampleEmployees);

        // Act: call the controller method.
        Employees result = employeeController.getAllEmployees();

        // Assert: check the response.
        assertEquals(1, result.getEmployeeList().size());
        assertEquals("101", result.getEmployeeList().get(0).getEmployeeId());

        // Verify: confirm the controller called the manager.
        verify(employeeManager).getEmployees();
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

        // Act: call the controller method.
        ResponseEntity<Void> response =
            employeeController.addEmployee(employee);

        // Assert: the controller returns HTTP 201 Created.
        assertEquals(HttpStatus.CREATED, response.getStatusCode());

        // Verify: confirm the controller passed the employee
        // to the manager.
        verify(employeeManager).addEmployee(employee);
    }
}
