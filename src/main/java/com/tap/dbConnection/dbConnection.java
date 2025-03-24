package com.tap.dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection {
	private static final String URL = "jdbc:mysql://localhost:3306/employee_pay_roll";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Root@7022!";
	
	public static Connection getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
//			System.out.println("Connection is done");
			return DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException e) {
			throw new SQLException("Database driver not found", e);
		}
	}
}
