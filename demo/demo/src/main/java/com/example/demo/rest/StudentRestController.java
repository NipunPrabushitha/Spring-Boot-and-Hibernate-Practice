package com.example.demo.rest;

import com.example.demo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Nipun","Prabushitha"));
        students.add(new Student("Apeksha","Vidanage"));
        students.add(new Student("Pathum","Sankalpa"));
        return students;
    }
}
