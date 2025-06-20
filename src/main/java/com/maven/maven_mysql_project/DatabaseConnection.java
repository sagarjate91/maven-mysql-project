package com.maven.maven_mysql_project;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	
	//SOLID
	//S->single resposiblity Prin
	//O-> Open Close Prin
	//L-> Liskov Substitution Principle
	// I-> Interface Segregation Principle
	// D->Dependency Inversion Principle

	// Create Database connection
	private final static String URL = "jdbc:mysql://localhost:3306/my_first_db";
	private final static String USERNAME = "root";
	private final static String PASSWORD = "admin";
	
	public static Connection con() {
	
		Connection connection = null;
		try {

			// Which DBMS(MYSQL) I want confirgure
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Register is successfully!!");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (Exception e) {

		}
		return connection;
	}

}
