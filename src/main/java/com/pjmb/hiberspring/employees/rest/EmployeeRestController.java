package com.pjmb.hiberspring.employees.rest;

import com.pjmb.hiberspring.employees.entity.Employee;
import com.pjmb.hiberspring.employees.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService) {
        this.employeeService = theEmployeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getStudents() {
        List<Employee> theEmployees = employeeService.findAll();
        return theEmployees;
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        Employee employee = employeeService.findById(employeeId);

        if (employee == null) {
            throw new RuntimeException("Employee id not found");
        }

        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee) {
        System.out.println("Post Employee");
        // In case they pass an ID in JSON, set ID = 0
        // to force saving a new Item instead of an update
        theEmployee.setId(0);
        Employee newEmployee = employeeService.save(theEmployee);
        return newEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee) {
        System.out.println("Put Employee");
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }
}
