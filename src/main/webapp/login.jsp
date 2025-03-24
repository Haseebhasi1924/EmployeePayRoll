<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - GigLabz</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link rel="stylesheet" href="css/login.css">
</head>
<body>
    <!-- Header -->
    <header class="header">
        <div class="container">
            <h1>GigLabz Private Limited</h1>
            <p>Employee Payroll System</p>
        </div>
    </header>

    <!-- Login Container -->
    <div class="login-container">
        <h2>Login</h2>
        <form action="login" method="post">
            <div class="form-group">
                <input type="text" class="form-control" name="username" placeholder="Username" required>
            </div>
            <div class="form-group">
                <input type="password" class="form-control" name="password" placeholder="Password" required>
            </div>
            <button type="submit" class="btn-login">Login</button>
        </form>
    </div>

    <!-- Footer -->
    <footer class="footer">
        <div class="container">
            <p>&copy; 2023 GigLabz Private Limited. All rights reserved.</p>
            <p>Address: Situated on, Room Number - 14, BHIVE Workspace, 467/468, Shri Krishna Temple Rd, Indira Nagar 1st Stage, Stage 1, Indiranagar, Bengaluru, Karnataka 560038</p>
            <p>Phone: 099451 44211</p>
        </div>
    </footer>

    <!-- Bootstrap JS (Optional) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>