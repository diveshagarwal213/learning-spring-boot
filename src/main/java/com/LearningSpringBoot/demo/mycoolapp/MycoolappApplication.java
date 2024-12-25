package com.LearningSpringBoot.demo.mycoolapp;

import java.util.List;

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
			// createStudent(studentDAO);
			// readStudent(studentDAO);
			// getAllStudents(studentDAO);
			getAllByLastName(studentDAO);
		};
	}

	private void getAllByLastName(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findByLastName("test1");
		for (Student stu : students) {
			System.out.println("Student Id: " + stu.toString());
		}
	}

	private void getAllStudents(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAll();
		for (Student stu : students) {
			System.out.println("Student Id: " + stu.getId());
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		Student myStudent = studentDAO.findById(1);
		System.out.println(myStudent.toString());
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
