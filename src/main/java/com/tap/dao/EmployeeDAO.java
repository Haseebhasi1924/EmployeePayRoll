package com.tap.dao;

import java.util.List;

import com.tap.entity.Employee;

public interface EmployeeDAO {
	Employee findByUsernameAndPassword(String username, String password) ; // Find employee by username
    Employee getEmployeeById(int employeeId); // Get employee by ID
    List<Employee> getAllEmployees(); // Get all employees (for Admin)
    boolean addEmployee(Employee employee); // Add new employee (for registration)
    boolean updateEmployee(Employee employee); // Update employee details
    boolean deleteEmployee(int employeeId); // Update employee details

}
