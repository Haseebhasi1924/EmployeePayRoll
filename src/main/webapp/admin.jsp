<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.tap.entity.Employee" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link rel="stylesheet" href="css/admin.css">
</head>
<body class="bg-light">
    <div class="container">
        <!-- Heading -->
        <h1 class="text-center my-4 text-success">Admin Dashboard</h1>

        <!-- Display Success or Error Messages -->
        <%
            String error = request.getParameter("error");
            String success = request.getParameter("success");
            if (error != null) {
        %>
                <div class="alert alert-danger text-center"><%= error %></div>
        <%
            }
            if (success != null) {
        %>
                <div class="alert alert-success text-center"><%= success %></div>
        <%
            }
        %>

        <!-- Employee Table -->
        <div class="table-responsive">
            <table class="table table-bordered table-striped table-hover">
                <thead class="table-success">
                    <tr>
                        <th>Employee ID</th>
                        <th>Name</th>
                        <th>Designation</th>
                        <th>Basic Salary</th>
                        <th>Allowances</th>
                        <th>Gross Salary</th>
                        <th>Tax Percentage</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        List<Employee> employees = (List<Employee>) request.getAttribute("employees");
                        if (employees != null && !employees.isEmpty()) {
                            for (Employee employee : employees) {
                    %>
                                <tr>
                                    <td><%= employee.getEmployeeId() %></td>
                                    <td><%= employee.getName() %></td>
                                    <td><%= employee.getDesignation() %></td>
                                    <td><%= employee.getBasicSalary() %></td>
                                    <td><%= employee.getAllowances() %></td>
                                    <td><%= employee.getGrossSalary() %></td>
                                    <td><%= employee.getTaxPercentage() %>%</td>
                                </tr>
                    <%
                            }
                        } else {
                    %>
                            <tr>
                                <td colspan="7" class="text-center text-muted">No employees found.</td>
                            </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>

        <!-- Manage Users Button -->
        <div class="text-center my-4">
            <button class="btn btn-success" onclick="showManageOptions()">Manage Users</button>
        </div>

        <!-- Manage Users Options -->
        <div id="manage-options" class="d-none">
            <div class="row">
                <!-- Left Column: Add User -->
                <div class="col-md-6">
                    <div class="card mb-4">
                        <div class="card-body">
                            <h2 class="card-title text-success">Add User</h2>
                            <form action="addUser" method="post">
                                <div class="mb-3">
                                    <input type="text" class="form-control" name="name" placeholder="Name" required>
                                </div>
                                <div class="mb-3">
                                    <input type="text" class="form-control" name="designation" placeholder="Designation" required>
                                </div>
                                <div class="mb-3">
                                    <input type="number" class="form-control" name="basicSalary" placeholder="Basic Salary" required>
                                </div>
                                <div class="mb-3">
                                    <input type="number" class="form-control" name="taxPercentage" placeholder="Tax Percentage" required>
                                </div>
                                <div class="mb-3">
                                    <input type="text" class="form-control" name="username" placeholder="Username" required>
                                </div>
                                <div class="mb-3">
                                    <input type="password" class="form-control" name="password" placeholder="Password" required>
                                </div>
                                <div class="mb-3">
                                    <input type="number" class="form-control" name="allowances" placeholder="Allowances" required>
                                </div>
                                <button type="submit" class="btn btn-success w-100">Add User</button>
                            </form>
                        </div>
                    </div>
                </div>

                <!-- Right Column: Update User and Delete User -->
                <div class="col-md-6">
                    <div class="card mb-4">
                        <div class="card-body">
                            <h2 class="card-title text-success">Update User</h2>
                            <form action="updateUser" method="get">
                                <div class="mb-3">
                                    <input type="number" class="form-control" name="employeeId" placeholder="Employee ID" required>
                                </div>
                                <button type="submit" class="btn btn-success w-100">Fetch Details</button>
                            </form>
                        </div>
                    </div>

                    <div class="card mb-4">
                        <div class="card-body">
                            <h2 class="card-title text-success">Delete User</h2>
                            <form action="deleteUser" method="post">
                                <div class="mb-3">
                                    <input type="number" class="form-control" name="employeeId" placeholder="Employee ID" required>
                                </div>
                                <button type="submit" class="btn btn-danger w-100">Delete User</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS (Optional) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <script>
        function showManageOptions() {
            document.getElementById("manage-options").classList.remove("d-none");
        }
    </script>
</body>
</html>