package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {
	
	public static Connection getConnection() {
		try {
			Connection con = null;
			Class.forName("com.mysql.jdbc.Driver");  
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pizza","root","root"); 
			
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "pizza", "pizza");
			
			return con;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
