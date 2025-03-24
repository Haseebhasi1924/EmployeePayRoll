<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.tap.entity.Employee" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Update User</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link rel="stylesheet" href="css/updateUser.css">
    <script>
        function showUpdateForm(field) {
            // Hide all forms
            document.getElementById("updateBasicSalaryForm").style.display = "none";
            document.getElementById("updateAllowancesForm").style.display = "none";
            document.getElementById("updatePasswordForm").style.display = "none";

            // Show the selected form
            document.getElementById(field + "Form").style.display = "block";
        }
    </script>
</head>
<body class="bg-light">
    <div class="container my-5">
        <div class="form-container card shadow p-4">
            <h2 class="text-center text-success mb-4">Update User</h2>
            <%
                String error = request.getParameter("error");
                String success = request.getParameter("success");
                Employee employee = (Employee) request.getAttribute("employee");

                if (error != null) {
                    out.println("<div class='alert alert-danger text-center'>" + error + "</div>");
                }
                if (success != null) {
                    out.println("<div class='alert alert-success text-center'>" + success + "</div>");
                }
            %>

            <%
                if (employee != null) {
            %>
                    <!-- Display Employee Details -->
                    <div class="employee-details mb-4">
                        <h3 class="text-center mb-3">Employee Details</h3>
                        <div class="row">
                            <div class="col-md-6">
                                <p><strong>Name:</strong> <%= employee.getName() %></p>
                                <p><strong>Designation:</strong> <%= employee.getDesignation() %></p>
                                <p><strong>Basic Salary:</strong> ₹<%= employee.getBasicSalary() %></p>
                            </div>
                            <div class="col-md-6">
                                <p><strong>Tax Percentage:</strong> <%= employee.getTaxPercentage() %>%</p>
                                <p><strong>Username:</strong> <%= employee.getUsername() %></p>
                                <p><strong>Allowances:</strong> ₹<%= employee.getAllowances() %></p>
                            </div>
                        </div>
                    </div>

                    <!-- Buttons for different actions -->
                    <div class="text-center mb-4">
                        <button class="btn btn-success mx-2" onclick="showUpdateForm('updateBasicSalary')">Update Basic Salary</button>
                        <button class="btn btn-success mx-2" onclick="showUpdateForm('updateAllowances')">Update Allowances</button>
                        <button class="btn btn-success mx-2" onclick="showUpdateForm('updatePassword')">Update Password</button>
                    </div>

                    <!-- Forms for updating fields -->
                    <div id="updateBasicSalaryForm" class="update-form" style="display: none;">
                        <form action="updateUser" method="post" class="mb-4">
                            <input type="hidden" name="employeeId" value="<%= employee.getEmployeeId() %>">
                            <input type="hidden" name="action" value="updateBasicSalary">
                            <div class="mb-3">
                                <label class="form-label">New Basic Salary:</label>
                                <input type="number" class="form-control" name="newBasicSalary" placeholder="New Basic Salary" min="0" required>
                            </div>
                            <button type="submit" class="btn btn-success w-100">Update</button>
                        </form>
                    </div>

                    <div id="updateAllowancesForm" class="update-form" style="display: none;">
                        <form action="updateUser" method="post" class="mb-4">
                            <input type="hidden" name="employeeId" value="<%= employee.getEmployeeId() %>">
                            <input type="hidden" name="action" value="updateAllowances">
                            <div class="mb-3">
                                <label class="form-label">New Allowances:</label>
                                <input type="number" class="form-control" name="newAllowances" placeholder="New Allowances" min="0" required>
                            </div>
                            <button type="submit" class="btn btn-success w-100">Update</button>
                        </form>
                    </div>

                    <div id="updatePasswordForm" class="update-form" style="display: none;">
                        <form action="updateUser" method="post" class="mb-4">
                            <input type="hidden" name="employeeId" value="<%= employee.getEmployeeId() %>">
                            <input type="hidden" name="action" value="updatePassword">
                            <div class="mb-3">
                                <label class="form-label">New Password:</label>
                                <input type="password" class="form-control" name="newPassword" placeholder="New Password" required>
                            </div>
                            <button type="submit" class="btn btn-success w-100">Update</button>
                        </form>
                    </div>
            <%
                } else {
                    out.println("<div class='alert alert-danger text-center'>Employee not found.</div>");
                }
            %>
        </div>
    </div>

    <!-- Bootstrap JS (Optional) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>