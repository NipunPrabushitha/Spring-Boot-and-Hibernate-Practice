package com.example.cruddemo;

import com.example.cruddemo.dao.StudentDAO;
import com.example.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner->{
            //createStudent(studentDAO);

            //createMultipleStudents(studentDAO);

            //readStudent(studentDAO);

            queryForStudent(studentDAO);
        };
    }

    private void queryForStudent(StudentDAO studentDAO) {
        List<Student> students = studentDAO.findAll();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private void readStudent(StudentDAO studentDAO) {
        System.out.println("Creating new student object...");
        Student student = new Student("Chamal","Anuradha","chamal@gmai.com");

        System.out.println("Saving student object...");
        studentDAO.save(student);

        int id = student.getId();
        System.out.println("Saved student. Generated id: " + id);
        System.out.println("Finding student by ID..." + id);
        Student foundStudent = studentDAO.findById(id);
        System.out.println("Found the student by ID..." + foundStudent  );
    }

    private void createMultipleStudents(StudentDAO studentDAO) {
        System.out.println("Creating 3 new student objects");
        Student tempStudent1 = new Student("Shashi","Madhushan","shashi@gmail.com");
        Student tempStudent2 = new Student("Apeksha","Vidanage","apeksha@gmail.com");
        Student tempStudent3 = new Student("Udara","Sankalpa","udara@gmail.com");

        System.out.println("Saving 3 new student objects");
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);

    }

    private void createStudent(StudentDAO studentDAO) {
        System.out.println("Creating the new student");
        Student tempStudent = new Student("Nipun","Prabushitha","nprabushitha@gmail.com");

        System.out.println("Saving the student");
        studentDAO.save(tempStudent);

        System.out.println("Saved student. Generate id : " +  tempStudent.getId());
    }
}
