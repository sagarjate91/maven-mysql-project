package com.maven.maven_mysql_project;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class App {
	public static void main(String[] args) throws SQLException {

		try {

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter the operation No: 1.Insertion 2.Read 3.Update 4.delete");
			String operationName = br.readLine();
			switch (operationName) {
			case "Insertion":
				insertion();
				main(args);
				break;
			case "Read":
				read();
				main(args);
				break;
			case "Update":
				update();
				main(args);
				break;
			case "Delete":
				delete();
				main(args);
				break;
			default:
				System.out.println("Your choice is wrong!");
				main(args);
				break;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void delete() throws SQLException {
		System.out.println("Start the deleting the data!");
		Connection con = DatabaseConnection.con();
		String sql = "DELETE FROM EMPLOYEE WHERE EMP_ID=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, 3);

		int count = ps.executeUpdate();

		if (count > 0) {
			System.out.println("Data deleted successfully!");
		} else {
			System.out.println("Data deleted Un-successfully!");
		}
		ps.close();
	}

	private static void update() throws SQLException {
		System.out.println("Start the updating the data!");
		Connection con = DatabaseConnection.con();
		String sql = "UPDATE EMPLOYEE SET ADDRESS=? WHERE EMP_ID=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, "Mumbai");
		ps.setInt(2, 4);

		int count = ps.executeUpdate();

		if (count > 0) {
			System.out.println("Data updated successfully!");
		} else {
			System.out.println("Data updated Un-successfully!");
		}

		ps.close();

	}

	private static void read() throws SQLException {

		System.out.println("Start the reading the data!");
		Connection con = DatabaseConnection.con();

		// String sql="SELECT * FROM EMPLOYEE WHERE EMP_ID=?";
		String sql = "SELECT * FROM EMPLOYEE";
		PreparedStatement ps = con.prepareStatement(sql);
		// ps.setInt(1, 4);

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			System.out.println("EMP ID:" + rs.getInt(1));
			System.out.println("EMP FirstName:" + rs.getString(2));
			System.out.println("EMP LastName:" + rs.getString(3));
			System.out.println("EMP Email:" + rs.getString(4));
			System.out.println("EMP Mobile:" + rs.getString(5));
			System.out.println("EMP Address:" + rs.getString(6));
			System.out.println("....................................................");
		}
		ps.close();
	}

	private static void insertion() {
		try {

			// crtical code

			Connection con = DatabaseConnection.con();

			// Create Statement for insertion
			String query = "INSERT INTO EMPLOYEE VALUES(?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, 4);
			ps.setString(2, "Amol");
			ps.setString(3, "J");
			ps.setString(4, "a@gmail.com");
			ps.setString(5, "989047167");
			ps.setString(6, "Pune");

			int count = ps.executeUpdate();

			if (count > 0) {
				System.out.println("Data added successfully!");
			} else {
				System.out.println("Data added Un-successfully!");
			}

			ps.close();

		} catch (Exception e) {

			// cought exception
			e.printStackTrace();
		}
	}
}
