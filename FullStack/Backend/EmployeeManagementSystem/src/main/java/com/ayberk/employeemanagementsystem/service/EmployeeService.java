package com.ayberk.employeemanagementsystem.service;

import com.ayberk.employeemanagementsystem.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Long id);
    Employee createEmployee(Employee employee);
    Employee updateEmployee(Long id,Employee employeeDetails);
    void deleteEmployeeById(Long id);
}
