package com.pjmb.hiberspring;

import java.util.List;

public interface StudentDAO {

    void save(Student theStudent);
    void update(Student theStudent);
    void delete(Integer id);
    int deleteAll();

    Student findById(Integer id);
    List<Student> findAll();
    List<Student> findAllByLastName(String lastName);
    List<Student> findAllByFirstName(String theFirstName);
}
