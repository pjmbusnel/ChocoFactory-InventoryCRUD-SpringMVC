package com.pjmb.hiberspring.students.dao;

import java.util.List;

public interface StudentDAO {

    void save(StudentEntity theStudent);
    void update(StudentEntity theStudent);
    void delete(Integer id);
    int deleteAll();

    StudentEntity findById(Integer id);
    List<StudentEntity> findAll();
    List<StudentEntity> findAllByLastName(String lastName);
    List<StudentEntity> findAllByFirstName(String theFirstName);
}
