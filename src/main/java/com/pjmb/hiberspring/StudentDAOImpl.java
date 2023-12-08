package com.pjmb.hiberspring;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student theStudent = entityManager.find(Student.class, id);
        entityManager.remove(theStudent);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int nbRowDeleted = entityManager
                .createQuery("DELETE FROM Student")
                .executeUpdate();
        return nbRowDeleted;
    }


    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> findStudentsQuery = entityManager.createQuery("FROM Student", Student.class);
        return findStudentsQuery.getResultList();
    }

    @Override
    public List<Student> findAllByLastName(String lastName) {
        TypedQuery<Student> findStudentsQuery = entityManager.createQuery("FROM Student WHERE lastName LIKE '%"+lastName+"%' order by lastName desc", Student.class);
        return findStudentsQuery.getResultList();
    }

    @Override
    public List<Student> findAllByFirstName(String theFirstName) {
        TypedQuery<Student> findStudentsQuery = entityManager.createQuery("FROM Student WHERE firstName=:theParam", Student.class);
        findStudentsQuery.setParameter("theParam", theFirstName);
        return findStudentsQuery.getResultList();
    }
}
