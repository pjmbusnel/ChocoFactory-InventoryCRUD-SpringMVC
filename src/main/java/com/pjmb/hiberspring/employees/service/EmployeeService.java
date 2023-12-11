package com.pjmb.hiberspring.employees.service;

import com.pjmb.hiberspring.employees.entity.Employee;
import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee theEmployee);
    void deleteById(int id);
}
