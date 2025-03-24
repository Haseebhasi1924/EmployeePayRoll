<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.tap.entity.Employee" %>
<!DOCTYPE html>
<html>
<head>
    <title>Profile</title>
    <link rel="stylesheet" href="css/profile.css">
</head>
<body>
    <div class="profile-container">
        <h2>Profile</h2>
        <%
            // Retrieve the employee object from the session
            Employee employee = (Employee) session.getAttribute("employee");
            if (employee != null) {
        %>
                <p><strong>Name:</strong> <%= employee.getName() %></p>
                <p><strong>Designation:</strong> <%= employee.getDesignation() %></p>
                <p><strong>Username:</strong> <%= employee.getUsername() %></p>
                <p><strong>Gross Salary:</strong> <%= employee.getGrossSalary() %></p>
                <p><strong>Tax deduction:</strong> <%= employee.getTaxPercentage() %></p>
        <%
            } else {
                // Redirect to login if employee is not in session
                response.sendRedirect(request.getContextPath() + "/login.jsp");
            }
        %>
        <form action="salarySlip" method="get">
            <button type="submit">Generate Salary Slip</button>
        </form>
    </div>
</body>
</html>