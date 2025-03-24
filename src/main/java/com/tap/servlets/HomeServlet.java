package com.tap.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.tap.dao.EmployeeDAO;
import com.tap.entity.Employee;
import com.tap.implementation.EmployeeDAOImpl;

@WebServlet("/admin")
public class HomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EmployeeDAO employeeDAO;

    public HomeServlet() {
        super();
        employeeDAO = new EmployeeDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Employee employee = (Employee) session.getAttribute("employee");

        // Check if user is logged in and is an admin
        if (employee == null || !employee.getDesignation().equalsIgnoreCase("admin")) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }

        // Fetch all employees for admin
        List<Employee> employees = employeeDAO.getAllEmployees();
        request.setAttribute("employees", employees);
        request.getRequestDispatcher("admin.jsp").forward(request, response);
    }
}