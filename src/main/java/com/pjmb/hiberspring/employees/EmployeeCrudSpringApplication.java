package com.pjmb.hiberspring.employees;

import com.pjmb.hiberspring.students.dao.StudentDAO;
import com.pjmb.hiberspring.students.dao.StudentEntity;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class EmployeeCrudSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeCrudSpringApplication.class, args);
	}

}
