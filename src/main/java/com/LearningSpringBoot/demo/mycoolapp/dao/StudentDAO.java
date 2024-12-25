package com.LearningSpringBoot.demo.mycoolapp.dao;

import java.util.List;

import com.LearningSpringBoot.demo.mycoolapp.entity.Student;

public interface StudentDAO {
    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String lastName);
}
