package dev.anthony.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {


	// JDBC Java Database Connectivity

	// one connection in this application that we will pass around
	private static Connection connection = null;
	
	// we only have one connection object in the application ever!!
	public static Connection getConnection() {
		
		if(connection == null) {
			return createConnection();
		}else {
			return connection;
		}
	}
	
	private static Connection createConnection() {
		
		Properties props = new Properties();
		FileInputStream in;
		try {
			in = new FileInputStream("src/main/resources/connection.properties");
			props.load(in);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		String connectDetails = props.getProperty("connectInfo");
		
		try {
			Connection conn = DriverManager.getConnection(connectDetails);
			connection = conn;
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
			
	}
}
