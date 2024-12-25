package com.LearningSpringBoot.demo.mycoolapp.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.LearningSpringBoot.demo.mycoolapp.entity.Student;

import jakarta.persistence.EntityManager;

@Repository
public class StudentImpl implements StudentDAO {

    // define field for entity manager
    private EntityManager entityManager;

    // inject entity manager using constructor injection
    // @Autowired // auto no need to define
    public StudentImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // implement save method
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

}
