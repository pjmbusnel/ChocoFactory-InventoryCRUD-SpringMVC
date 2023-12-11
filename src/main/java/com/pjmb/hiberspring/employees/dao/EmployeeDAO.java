package com.pjmb.hiberspring.employees.dao;

import com.pjmb.hiberspring.employees.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    Employee findById(int id);
    List<Employee> findAll();
    Employee save(Employee theEmployee);
    void deleteById(int id);

}
