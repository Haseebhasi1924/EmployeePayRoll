<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.tap.entity.Employee" %>
<!DOCTYPE html>
<html>
<head>
    <title>Salary Slip</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link rel="stylesheet" href="css/salarySlip.css">
</head>
<body>
    <div class="salary-slip-container">
        <h2>Salary Slip</h2>
        <div class="card">
            <%
                // Retrieve attributes from the request
                Employee employee = (Employee) request.getAttribute("employee");
                Double basicSalary = (Double) request.getAttribute("basicSalary");
                Double allowances = (Double) request.getAttribute("allowances");
                Double grossSalary = (Double) request.getAttribute("grossSalary");
                Double taxPercentage = (Double) request.getAttribute("taxPercentage");
                Double taxAmount = (Double) request.getAttribute("taxAmount");
                Double netSalary = (Double) request.getAttribute("netSalary");
                String formula = (String) request.getAttribute("formula");

                if (employee != null) {
            %>
                    <p><strong>Name:</strong> <%= employee.getName() %></p>
                    <p><strong>Designation:</strong> <%= employee.getDesignation() %></p>
                    <p><strong>Basic Salary:</strong> ₹<%= basicSalary %></p>
                    <p><strong>Allowances:</strong> ₹<%= allowances %></p>
                    <p><strong>Gross Salary:</strong> ₹<%= grossSalary %></p>
                    <p><strong>Tax Percentage:</strong> <%= taxPercentage %>%</p>
                    <p><strong>Tax Deduction:</strong> ₹<%= taxAmount %></p>
                    <p><strong>Net Salary:</strong> ₹<%= netSalary %></p>
                    <p class="formula"><strong>Formula:</strong> <%= formula %></p>
            <%
                } else {
                    // Redirect to login if employee is not in session
                    response.sendRedirect(request.getContextPath() + "/login.jsp");
                }
            %>
        </div>
    </div>
</body>
</html>