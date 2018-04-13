package com.yixuan.interview.servlet.dao;

import java.sql.DriverManager;
import java.sql.ResultSet;

public class LoginDao {
	
	String sql = "select * from login where username=? and password=?";
	String url = "jdbc:mysql://localhost:3306/Hello_World";
	String uname="root";
	String pass="911203gyx";
	public boolean check(String username, String password) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection(url,uname,pass);
			java.sql.PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, username);
			st.setString(2, password);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
