package com.example.restCrudDemo.service;

import com.example.restCrudDemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(Integer id);
}
