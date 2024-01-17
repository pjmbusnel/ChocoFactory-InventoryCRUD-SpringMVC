package com.pjmb.spring.employees.repository;

import com.pjmb.spring.employees.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {}
