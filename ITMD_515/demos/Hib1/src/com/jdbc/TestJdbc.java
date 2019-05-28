package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
	public static void main(String[] args) {

		String jdbcUrl = "jdbc:mysql://www.papademas.net/mydb?useSSL=false";
		String userName = "dbuser";
		String password = "db1";

		try {
			System.out.println("Connecting to database: " + jdbcUrl);
			Connection connection = DriverManager.getConnection(jdbcUrl, userName, password);
			System.out.println("Connection Successful!");
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
