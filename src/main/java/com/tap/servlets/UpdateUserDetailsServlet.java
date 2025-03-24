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

@WebServlet("/updateUser")
public class UpdateUserDetailsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EmployeeDAO employeeDAO;

    public UpdateUserDetailsServlet() {
        super();
        employeeDAO = new EmployeeDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Fetch employee details
        String employeeIdStr = request.getParameter("employeeId");
        if (employeeIdStr != null && !employeeIdStr.isEmpty()) {
            int employeeId = Integer.parseInt(employeeIdStr);
            Employee employee = employeeDAO.getEmployeeById(employeeId);

            if (employee != null) {
                request.setAttribute("employee", employee);
            } else {
                request.setAttribute("error", "Employee not found");
            }
        } else {
            request.setAttribute("error", "Employee ID is required");
        }

        // Forward to the JSP page
        request.getRequestDispatcher("updateUser.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve common parameters
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        String action = request.getParameter("action");

        // Fetch the employee from the database
        Employee employee = employeeDAO.getEmployeeById(employeeId);

        if (employee != null) {
            switch (action) {
                case "updateBasicSalary":
                    double newBasicSalary = Double.parseDouble(request.getParameter("newBasicSalary"));
                    employee.setBasicSalary(newBasicSalary);
                    break;

                case "updateAllowances":
                    double newAllowances = Double.parseDouble(request.getParameter("newAllowances"));
                    employee.setAllowances(newAllowances);
                    break;

                case "updatePassword":
                    String newPassword = request.getParameter("newPassword");
                    if (newPassword != null && !newPassword.trim().isEmpty()) {
                        employee.setPassword(newPassword);
                    } else {
                        response.sendRedirect(request.getContextPath() + "/admin?error=Password cannot be empty");
                        return;
                    }
                    break;

                default:
                    response.sendRedirect(request.getContextPath() + "/admin?error=Invalid action");
                    return;
            }

            // Update the employee in the database
            boolean isUpdated = employeeDAO.updateEmployee(employee);

            if (isUpdated) {
                response.sendRedirect(request.getContextPath() + "/admin?success=Employee updated successfully");
            } else {
                response.sendRedirect(request.getContextPath() + "/admin?error=Failed to update employee");
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/admin?error=Employee not found");
        }
    }
}