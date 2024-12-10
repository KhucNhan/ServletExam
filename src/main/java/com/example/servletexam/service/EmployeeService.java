package com.example.servletexam.service;

import com.example.servletexam.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAllEmployee();
    void updateEmployee(int id, Employee employee);

    void createEmployee(Employee employee);

    void deleteEmployee(int id);

    Employee findById(int id);
}
