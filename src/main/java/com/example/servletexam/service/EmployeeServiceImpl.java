package com.example.servletexam.service;

import com.example.servletexam.model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EmployeeServiceImpl implements EmployeeService{
    private static Map<Integer, Employee> employees;
    static {
        employees.put(1, new Employee(1, "A", 19, "Dev", "IT", 1000000));
        employees.put(2, new Employee(2, "B", 20, "Ba", "IT", 1000));
        employees.put(3, new Employee(3, "C", 21, "Qa", "IT", 1000));
    }
    @Override
    public List<Employee> findAllEmployee() {
        return new ArrayList<>(employees.values());
    }

    @Override
    public void updateEmployee(int id, Employee employee) {
        employees.put(id, employee);
    }

    @Override
    public void createEmployee(Employee employee) {
        employees.put(employee.getId(), employee);
    }

    @Override
    public void deleteEmployee(int id) {
        employees.remove(id);
    }

    @Override
    public Employee findById(int id) {
        return employees.get(id);
    }
}
