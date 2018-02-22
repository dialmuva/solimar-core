package com.solimar.dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class PostgreSQLConnection {
	
	public Connection getConnection(){
		
		/*String url = "jdbc:postgresql://localhost/test";
		Properties props = new Properties();
		props.setProperty("user","fred");
		props.setProperty("password","secret");
		props.setProperty("ssl","true");
		Connection conn = DriverManager.getConnection(url, props);*/
		String url = "jdbc:postgresql://localhost:5432/solimar?user=user&password=password";
		Connection conn;
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			conn = null;
			e.printStackTrace();
		}
		return conn;
	}
	

}
