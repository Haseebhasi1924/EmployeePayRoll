# EmployeePayRoll
# Employee Payroll System

A Java-based web application for managing employee payroll with admin functionalities.

## Features

- **Admin Dashboard**: View, add, update, and delete employees
- **Login System**: Secure authentication for admin users
- **Payroll Management**: Track salaries, allowances, and taxes
- **Responsive UI**: Works on desktop and mobile devices

## Technologies Used

- **Backend**: Java Servlets, JSP
- **Frontend**: HTML5, CSS3, Bootstrap 5
- **Database**: MySQL
- **Server**: Apache Tomcat

## Key Functionalities

1. Admin can:
   - View all employee records
   - Add new employees
   - Update salaries/allowances
   - Delete employees
2. Secure login system
3. Automatic salary calculations (gross salary, tax deductions)

src/
├── main/
│   ├── java/
│   │   └── com/tap/
│   │       ├── servlets/
│   │       │   ├── AdminServlet.java
│   │       │   ├── LoginServlet.java
│   │       │   ├── AddUserServlet.java
│   │       │   ├── UpdateUserServlet.java
│   │       │   └── DeleteUserServlet.java
│   │       │
│   │       ├── dao/
│   │       │   └── EmployeeDAO.java
│   │       │
│   │       ├── implementation/
│   │       │   └── EmployeeDAOImpl.java
│   │       │
│   │       ├── entity/
│   │       │   └── Employee.java
│   │       │
│   │       └── util/
│   │           └── DBConnection.java
│   │
│   ├── webapp/
│   │   ├── WEB-INF/
│   │   │   └── web.xml
│   │   ├── css/
│   │   │   ├── admin.css
│   │   │   └── login.css
│   │   ├── js/
│   │   │   └── script.js
│   │   ├── images/
│   │   ├── admin.jsp
│   │   ├── login.jsp
│   │   ├── updateUser.jsp
│   │   └── index.jsp
│   │
│   └── resources/
│       └── db.properties
│
├── test/
│   └── java/
│       └── com/tap/
│           ├── dao/
│           │   └── EmployeeDAOTest.java
│           └── servlets/
│               └── LoginServletTest.java
