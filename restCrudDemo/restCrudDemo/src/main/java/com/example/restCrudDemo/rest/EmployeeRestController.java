package com.example.restCrudDemo.rest;


import com.example.restCrudDemo.entity.Employee;
import com.example.restCrudDemo.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    //private EmployeeDAO employeeDAO;

    private ObjectMapper objectMapper;

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService,ObjectMapper theObjectMapper) {
        employeeService = theEmployeeService;
        objectMapper = theObjectMapper;
    }
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        Employee theEmployee = employeeService.findById(employeeId);
        if (theEmployee == null) {
            throw new RuntimeException("Employee not found "+employeeId);
        }
        return theEmployee;
    }
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee) {
        theEmployee.setId(0);
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;

    }
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee) {
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }
    @PatchMapping("/employees/{employeeId}")
    public Employee patchEmployee(@RequestBody Map<String,Object> patchPayload, @PathVariable int employeeId) {
        Employee tempEmployee = employeeService.findById(employeeId);
        if (tempEmployee == null) {
            throw new RuntimeException("Employee not found - "+employeeId);
        }
        if (patchPayload.containsKey("id")) {
            throw new RuntimeException("Employee id not allowed in the request body - "+employeeId);
        }
        Employee patchEmployee = apply(patchPayload,tempEmployee);
        Employee dbEmployee = employeeService.save(patchEmployee);
        return dbEmployee;
    }
    private Employee apply(Map<String,Object> patchPayload, Employee theEmployee) {
        ObjectNode employeeNode = objectMapper.convertValue(theEmployee,ObjectNode.class);

        ObjectNode patchNode = objectMapper.convertValue(patchPayload,ObjectNode.class);

        employeeNode.setAll(patchNode);
        return objectMapper.convertValue(employeeNode,Employee.class);
    }
}
