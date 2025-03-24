package com.tap.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.tap.dao.EmployeeDAO;
import com.tap.entity.Employee;
import com.tap.implementation.EmployeeDAOImpl;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EmployeeDAO employeeDAO;

    public LoginServlet() {
        super();
        employeeDAO = new EmployeeDAOImpl();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Authenticate user
        Employee employee = employeeDAO.findByUsernameAndPassword(username, password);
        if (employee != null) {
            // Create session and store employee details
            HttpSession session = request.getSession();
            session.setAttribute("employee", employee);

            // Redirect based on designation (role)
            if (employee.getDesignation().equalsIgnoreCase("admin")) {
                response.sendRedirect(request.getContextPath() + "/admin");//HomeServlet
            } else {
                response.sendRedirect(request.getContextPath() + "/profile");
            }
        } else {
            // Invalid credentials
            request.setAttribute("error", "Invalid username or password");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}