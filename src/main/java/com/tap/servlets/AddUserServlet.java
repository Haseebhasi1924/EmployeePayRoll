package com.tap.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import com.tap.dao.EmployeeDAO;
import com.tap.entity.Employee;
import com.tap.implementation.EmployeeDAOImpl;

@WebServlet("/addUser")
public class AddUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EmployeeDAO employeeDAO;

    public AddUserServlet() {
        super();
        employeeDAO = new EmployeeDAOImpl();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve form data
        String name = request.getParameter("name");
        String designation = request.getParameter("designation");
        double basicSalary = Double.parseDouble(request.getParameter("basicSalary"));
        double taxPercentage = Double.parseDouble(request.getParameter("taxPercentage"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        double allowances = Double.parseDouble(request.getParameter("allowances"));

        // Create Employee object
        Employee employee = new Employee(0, name, designation, basicSalary, taxPercentage, username, password, allowances);

        // Add employee to the database
        boolean isAdded = employeeDAO.addEmployee(employee);

        if (isAdded) {
            response.sendRedirect(request.getContextPath() + "/admin");
        } else {
            response.sendRedirect(request.getContextPath() + "/admin?error=Failed to add user");
        }
    }
}