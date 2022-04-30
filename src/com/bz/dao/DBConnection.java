package com.bz.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static final DBConnection _INSTANCE = new DBConnection();
	
	private static Connection connection;
	
	public DBConnection() {
		try {
			//1st Loading Drivers
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver is loaded....");
			//2nd Connect your db
			final String dbName = "bank_management_system";
			final String baseUrl = "jdbc:mysql://";
			final String hostUrl = "localhost:3306/";
			String url = baseUrl+hostUrl+dbName;
			
			final String username = "root";
			final String password = "mysql";
			
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("Connection is successfull...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static DBConnection getInstance() {
		return _INSTANCE;
	}

	public Connection getConnection() {
		return connection;
	}
}
