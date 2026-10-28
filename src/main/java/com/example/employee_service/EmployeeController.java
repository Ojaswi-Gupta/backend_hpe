// package com.example.employee_service;

// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RestController;

// @RestController
// public class EmployeeController {

//     private final EmployeeManager employeeManager;

//     public EmployeeController(EmployeeManager employeeManager) {
//         this.employeeManager = employeeManager;
//     }

//     // GET: Retrieve all employees
//     @GetMapping("/employees")
//     public Employees getAllEmployees() {
//         return employeeManager.getEmployees();
//     }

//     // POST: Add a new employee
//     @PostMapping("/employees")
//     public Employees addEmployee(@RequestBody Employee employee) {
//         employeeManager.addEmployee(employee);
//         return employeeManager.getEmployees();
//     }
// }


package com.example.employee_service;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    private final EmployeeManager employeeManager;

    public EmployeeController(EmployeeManager employeeManager) {
        this.employeeManager = employeeManager;
    }

    // GET: Retrieve all employees
    @GetMapping(value = "/employees",produces = MediaType.APPLICATION_JSON_VALUE)
    public Employees getAllEmployees() {
        return employeeManager.getEmployees();
    }

    // POST: Add a new employee
    @PostMapping(value = "/employees",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addEmployee(@RequestBody Employee employee) {
        employeeManager.addEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
