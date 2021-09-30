package com.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.beans.User;
import com.beans.UserCredentials;
import com.util.DbUtil;

public class LoginDao {
	
	public boolean login(UserCredentials user) {
		try {
			Connection con = DbUtil.getConnection();
			String cmd = "select usertype from usercredentials where userid=? and password=?";
			PreparedStatement ps = con.prepareStatement(cmd);
			ps.setString(1, user.getUserId());
			ps.setString(2, user.getPassword());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				cmd = "update usercredentials set loginstatus = 1 where userid=? and password=?";
				ps = con.prepareStatement(cmd);
				ps.setString(1, user.getUserId());
				ps.setString(2, user.getPassword());
				ps.executeUpdate();
				return true;
			}
			return false;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean signup(UserCredentials user) {
		try {
			Connection con = DbUtil.getConnection();
			String cmd = "insert into usercredentials values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(cmd);
			ps.setString(1, user.getUserId());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getUserType());
			if(user.getLoginStatus())
				ps.setInt(4, 1);
			else
				ps.setInt(4, 0);
			int n = ps.executeUpdate();
			if(n>=1) {
				return true;
			}
			return false;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean logout(String user) {
		try {
			Connection con = DbUtil.getConnection();
			String cmd = "update usercredentials set loginstatus = 0 where userid=?";
			PreparedStatement ps = con.prepareStatement(cmd);
			ps.setString(1, user);
			
			int n = ps.executeUpdate();
			if(n>=1) {
				return true;
			}
			return false;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean register(User user) {
		try {
			Connection con = DbUtil.getConnection();
			String cmd = "INSERT INTO USERPROFILE VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(cmd);
			ps.setString(1, user.getUserId());
			ps.setString(2, user.getFirstName());
			ps.setString(3, user.getLastName());
			Date d = new Date(user.getDateOfBirth().getTime());
			ps.setDate(4, d);
			ps.setString(5, user.getGender());
			ps.setString(6, user.getStreet());
			ps.setString(7, user.getLocation());
			ps.setString(8, user.getCity());
			ps.setString(9, user.getStreet());
			ps.setInt(10, user.getPincode());
			ps.setLong(11, user.getMobileNumber());
			ps.setString(12, user.getEmailId());
			int n = ps.executeUpdate();
			if(n >= 1)
				return true;
			else
				return false;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	

	public String getMobile(String user) {
		try {
			Connection con = DbUtil.getConnection();
			String cmd = "select mobileno from userprofile where userid = ?";
			PreparedStatement ps = con.prepareStatement(cmd);
			ps.setString(1, user);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				int n = rs.getInt("mobileno");
				return Integer.toString(n);
			}
			else
				return "1234567890";
		} catch (SQLException e) {
			e.printStackTrace();
			return "1234567890";
		}	
	}

	public void deleteCart(String user) {
		try {
			Connection con = DbUtil.getConnection();
			String cmd = "delete cart where userid=?";
			PreparedStatement ps = con.prepareStatement(cmd);
			ps.setString(1, user);
			@SuppressWarnings("unused")
			ResultSet rs = ps.executeQuery();
			return;
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}	
		
	}
	
	
}