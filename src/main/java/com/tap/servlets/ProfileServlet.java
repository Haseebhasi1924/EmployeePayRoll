package com.tap.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.tap.entity.Employee;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Employee employee = (Employee) session.getAttribute("employee");

        // Check if user is logged in
        if (employee == null) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }

        // Display employee's own details
        request.setAttribute("employee", employee);
        request.getRequestDispatcher("profile.jsp").forward(request, response);
    }
}