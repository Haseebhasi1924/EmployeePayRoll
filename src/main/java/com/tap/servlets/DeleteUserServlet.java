package com.tap.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.tap.dao.EmployeeDAO;
import com.tap.implementation.EmployeeDAOImpl;

@WebServlet("/deleteUser")
public class DeleteUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EmployeeDAO employeeDAO;

    public DeleteUserServlet() {
        super();
        employeeDAO = new EmployeeDAOImpl();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve the employee ID from the form
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));

        // Delete the employee from the database
        boolean isDeleted = employeeDAO.deleteEmployee(employeeId);

        if (isDeleted) {
            // Redirect with a success message
            response.sendRedirect(request.getContextPath() + "/admin?success=Employee deleted successfully");
        } else {
            // Redirect with an error message
            response.sendRedirect(request.getContextPath() + "/admin?error=Failed to delete employee");
        }
    }
}