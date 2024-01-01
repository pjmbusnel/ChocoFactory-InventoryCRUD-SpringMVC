package com.pjmb.hiberspring.employees.repository;

import com.pjmb.hiberspring.employees.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {}
