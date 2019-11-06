package com.arc.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnector {
	
	public static Connection getConnect() throws Exception {
		Connection con = null;
		String user = "spring01";
		String password = "spring01";
		String url = "jdbc:oracle:thin:@192.168.56.103:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		Class.forName(driver);
		
		con = DriverManager.getConnection(url, user, password);
		
		return con;
	}
}
