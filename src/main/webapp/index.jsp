<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %> 
<%@ page import="com.tap.entity.Employee" %>

<!DOCTYPE html>
<html>
<head>
    <title>Employee List</title>
    <link rel="stylesheet" href="css/index.css">
</head>
<body>
    <h1>Employee List</h1>
    <table>
        <thead>
            <tr>
                <th>Employee ID</th>
                <th>Name</th>
                <th>Designation</th>
                <th>Basic Salary</th>
                <th>Tax Percentage</th>
            </tr>
        </thead>
        <tbody>
            <%
                // Retrieve the list of employees from the request attribute
                List<Employee> employees = (List<Employee>) request.getAttribute("employees");

                if (employees != null && !employees.isEmpty()) {
                    for (Employee employee : employees) {
            %>
                        <tr>
                            <td><%= employee.getEmployeeId() %></td>
                            <td><%= employee.getName() %></td>
                            <td><%= employee.getDesignation() %></td>
                            <td><%= employee.getBasicSalary() %></td>
                            <td><%= employee.getTaxPercentage() %>%</td>
                        </tr>
            <%
                    }
                } else {
            %>
                    <tr>
                        <td colspan="5" class="no-data">No employees found.</td>
                    </tr>
            <%
                }
            %>
        </tbody>
    </table>
</body>
</html>
