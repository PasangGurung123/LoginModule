package com.Login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class LoginDao {
	String url = "jdbc:mysql://localhost:3306/jdbcdemo";
	String username = "root";
	String password = "RootAdmin@123";
	String query = "Select * from login where uname = ? and pass= ?;";
	public boolean check(String uname, String pass) {
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(url, username, password);
		PreparedStatement st = connection.prepareStatement(query);
		st.setString(1, uname);
		st.setString(2, pass);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			return true;
		}
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return false;
	}
}
