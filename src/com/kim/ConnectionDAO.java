package com.kim;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class ConnectionDAO {
	private final String URL = "jdbc:mariadb://localhost:3306/customerdb";
	private final String USER = "root";
	private final String PASS = "root";
	
	protected Connection conn = null;
	protected PreparedStatement ps = null;
	protected ResultSet rs = null;
	
	/**
	 * Connect to the classicmodels database
	 * @throws SQLException
	 */
	public void connectToDB() throws SQLException {
		conn = DriverManager.getConnection(URL,USER,PASS);
		
		
	}
	
	
	/**
	 * Close connection, preparedStatement and resultset
	 */
	public void closeConnections() {
		try {
			if(!conn.equals(null)) {
				if(!conn.isClosed()) {
					conn.close();
				}
			}
			if(!ps.equals(null)) {
				if(!ps.isClosed()) ps.close();
			}
			if(!rs.equals(null)) {
				if(!rs.isClosed()) rs.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}


}
