package com.example.restCrudDemo.service;

import com.example.restCrudDemo.dao.EmployeeRepository;
import com.example.restCrudDemo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository theEmployeeDAO) {
        employeeRepository = theEmployeeDAO;
    }
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {

        Optional<Employee> result = employeeRepository.findById(theId);
        Employee employee = null;
        if (result.isPresent()) {
            employee = result.get();
        }else{
            throw new RuntimeException("Did not find employee with id " + theId);
        }
        return employee;
    }


    @Override
    public Employee save(Employee employee) {
       return employeeRepository.save(employee);
    }


    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }
}
