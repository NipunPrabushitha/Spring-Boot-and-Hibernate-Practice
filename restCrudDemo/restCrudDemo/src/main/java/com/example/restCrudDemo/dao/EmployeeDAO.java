package com.example.restCrudDemo.dao;

import com.example.restCrudDemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
}
