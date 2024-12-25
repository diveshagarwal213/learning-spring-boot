package com.LearningSpringBoot.demo.mycoolapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.LearningSpringBoot.demo.mycoolapp.dao.StudentDAO;
import com.LearningSpringBoot.demo.mycoolapp.entity.Student;

@SpringBootApplication
public class MycoolappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MycoolappApplication.class, args);
	}

	// command line runner
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			createStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {

		// create student obj
		System.out.println("Creating Student");

		Student newStudent = new Student("ram", "test1", "test@email.com");
		// save
		studentDAO.save(newStudent);

		// print
		System.out.println("new Student _id" + newStudent.getId());

	}
}
