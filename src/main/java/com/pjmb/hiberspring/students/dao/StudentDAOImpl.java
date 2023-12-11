package com.pjmb.hiberspring.students.dao;

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
    public void save(StudentEntity theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    @Transactional
    public void update(StudentEntity theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        StudentEntity theStudent = entityManager.find(StudentEntity.class, id);
        entityManager.remove(theStudent);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int nbRowDeleted = entityManager
                .createQuery("DELETE FROM StudentEntity")
                .executeUpdate();
        return nbRowDeleted;
    }


    @Override
    public StudentEntity findById(Integer id) {
        return entityManager.find(StudentEntity.class, id);
    }

    @Override
    public List<StudentEntity> findAll() {
        TypedQuery<StudentEntity> findStudentsQuery = entityManager.createQuery("FROM StudentEntity", StudentEntity.class);
        return findStudentsQuery.getResultList();
    }

    @Override
    public List<StudentEntity> findAllByLastName(String lastName) {
        TypedQuery<StudentEntity> findStudentsQuery = entityManager.createQuery("FROM StudentEntity WHERE lastName LIKE '%"+lastName+"%' order by lastName desc", StudentEntity.class);
        return findStudentsQuery.getResultList();
    }

    @Override
    public List<StudentEntity> findAllByFirstName(String theFirstName) {
        TypedQuery<StudentEntity> findStudentsQuery = entityManager.createQuery("FROM StudentEntity WHERE firstName=:theParam", StudentEntity.class);
        findStudentsQuery.setParameter("theParam", theFirstName);
        return findStudentsQuery.getResultList();
    }
}
