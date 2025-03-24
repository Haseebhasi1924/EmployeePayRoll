package com.tap.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.EmployeeDAO;
import com.tap.dbConnection.dbConnection;
import com.tap.entity.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public Employee findByUsernameAndPassword(String username, String password) {
        String query = "SELECT * FROM Employee WHERE username = ? AND password = ?";
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new Employee(
                    resultSet.getInt("employeeId"),
                    resultSet.getString("name"),
                    resultSet.getString("designation"),
                    resultSet.getDouble("basicSalary"),
                    resultSet.getDouble("taxPercentage"),
                    resultSet.getString("username"),
                    resultSet.getString("password"),
                    resultSet.getDouble("allowances") // Fetch allowances
                );
            }
        } catch (SQLException e) {
            System.err.println("Error finding employee by username and password: " + e.getMessage());
        }
        return null;
    }

    @Override
    public Employee getEmployeeById(int employeeId) {
        String query = "SELECT * FROM Employee WHERE employeeId = ?";
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, employeeId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new Employee(
                    resultSet.getInt("employeeId"),
                    resultSet.getString("name"),
                    resultSet.getString("designation"),
                    resultSet.getDouble("basicSalary"),
                    resultSet.getDouble("taxPercentage"),
                    resultSet.getString("username"),
                    resultSet.getString("password"),
                    resultSet.getDouble("allowances") // Fetch allowances
                );
            }
        } catch (SQLException e) {
            System.err.println("Error fetching employee by ID: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        String query = "SELECT * FROM Employee";
        try (Connection connection = dbConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                employees.add(new Employee(
                    resultSet.getInt("employeeId"),
                    resultSet.getString("name"),
                    resultSet.getString("designation"),
                    resultSet.getDouble("basicSalary"),
                    resultSet.getDouble("taxPercentage"),
                    resultSet.getString("username"),
                    resultSet.getString("password"),
                    resultSet.getDouble("allowances") // Fetch allowances
                ));
            }
        } catch (SQLException e) {
            System.err.println("Error fetching all employees: " + e.getMessage());
        }
        return employees;
    }

    @Override
    public boolean addEmployee(Employee employee) {
        String query = "INSERT INTO Employee (name, designation, basicSalary, taxPercentage, username, password, allowances) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, employee.getName());
            statement.setString(2, employee.getDesignation());
            statement.setDouble(3, employee.getBasicSalary());
            statement.setDouble(4, employee.getTaxPercentage());
            statement.setString(5, employee.getUsername());
            statement.setString(6, employee.getPassword());
            statement.setDouble(7, employee.getAllowances()); // Insert allowances

            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error adding employee: " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        String query = "UPDATE Employee SET name=?, designation=?, basicSalary=?, taxPercentage=?, username=?, password=?, allowances=? WHERE employeeId=?";
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, employee.getName());
            statement.setString(2, employee.getDesignation());
            statement.setDouble(3, employee.getBasicSalary());
            statement.setDouble(4, employee.getTaxPercentage());
            statement.setString(5, employee.getUsername());
            statement.setString(6, employee.getPassword());
            statement.setDouble(7, employee.getAllowances());
            statement.setInt(8, employee.getEmployeeId());

            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error updating employee: " + e.getMessage());
        }
        return false;
    }
    @Override
    public boolean deleteEmployee(int employeeId) {
        String query = "DELETE FROM employee WHERE employeeId = ?";
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, employeeId);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0; // Return true if at least one row is deleted
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();

        // Fetch all employees
        List<Employee> employees = employeeDAO.getAllEmployees();

        // Print the results
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            System.out.println("Employee List:");
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
    }
}