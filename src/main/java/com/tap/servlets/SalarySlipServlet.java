package com.tap.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.tap.entity.Employee;

@WebServlet("/salarySlip")
public class SalarySlipServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Employee employee = (Employee) session.getAttribute("employee");

        if (employee == null) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }

        // Calculate salary details
        double basicSalary = employee.getBasicSalary();
        double allowances = employee.getAllowances();
        double grossSalary = basicSalary + allowances; // Gross Salary = Basic Salary + Allowances
        double taxPercentage = employee.getTaxPercentage();
        double taxAmount = (grossSalary * taxPercentage) / 100; // Tax Amount = Gross Salary * Tax Percentage / 100
        double netSalary = grossSalary - taxAmount; // Net Salary = Gross Salary - Tax Amount

        // Formula for salary calculation
        String formula = "Gross Salary = Basic Salary + Allowances <br>" +
                         "Net Salary = Gross Salary - (Gross Salary * Tax Percentage / 100)";

        // Set attributes for the salary slip
        request.setAttribute("employee", employee);
        request.setAttribute("basicSalary", basicSalary);
        request.setAttribute("allowances", allowances);
        request.setAttribute("grossSalary", grossSalary);
        request.setAttribute("taxPercentage", taxPercentage);
        request.setAttribute("taxAmount", taxAmount);
        request.setAttribute("netSalary", netSalary);
        request.setAttribute("formula", formula);

        // Forward to salarySlip.jsp
        request.getRequestDispatcher("salarySlip.jsp").forward(request, response);
    }
}