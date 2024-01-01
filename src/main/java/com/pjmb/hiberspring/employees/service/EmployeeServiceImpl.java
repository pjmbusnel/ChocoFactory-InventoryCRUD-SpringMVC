package com.pjmb.hiberspring.employees.service;

import com.pjmb.hiberspring.employees.entity.Employee;
import com.pjmb.hiberspring.employees.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepo;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepo) {
        this.employeeRepo = theEmployeeRepo;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepo.findAll();
    }

    @Override
    public Optional<Employee> findById(int id) {
        return employeeRepo.findById(id);
    }

    @Override
    @Transactional
    public Employee save(Employee theEmployee) {
        return employeeRepo.save(theEmployee);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        employeeRepo.deleteById(id);
    }


}
