package com.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedHashMap;

import com.beans.Cart;
import com.beans.Food;
import com.util.DbUtil;

public class CartDao {

	@SuppressWarnings("resource")
	public boolean addCart(Cart cart) {
		try {
			Connection con = DbUtil.getConnection();
			String cmd = "select quantity from cart where cartid = ? and foodid = ?";
			PreparedStatement ps = con.prepareStatement(cmd);
			ps.setString(1, cart.getCartId());
			ps.setString(2, cart.getFoodId());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				int quantity = rs.getInt("quantity");
				quantity += cart.getQuantity();
				cart.setQuantity(quantity);
			}
			Date d = new Date(cart.getOrderDate().getTime());
			if(cart.getQuantity() > 1) {
				cmd = "update cart set quantity=?, orderdate=? where cartid = ? and foodid = ?";
				ps = con.prepareStatement(cmd);
				ps.setString(3, cart.getCartId());
				ps.setString(4, cart.getFoodId());
				ps.setInt(1, cart.getQuantity());
				ps.setDate(2, d);
			}
			else {
				cmd = "insert into cart values(?,?,?,?,?)";
				ps = con.prepareStatement(cmd);
				ps.setString(1, cart.getCartId());
				ps.setString(2, cart.getUserId());
				ps.setString(3, cart.getFoodId());
				ps.setInt(4, cart.getQuantity());
				ps.setDate(5, d);
			}
			
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
	
	public LinkedHashMap<Food, Integer> getCart(String userId) {
		try {
			LinkedHashMap<Food, Integer> cart = new LinkedHashMap<Food, Integer>();
			Connection con = DbUtil.getConnection();
			String cmd = "select foodid, quantity from cart where userid = ?";
			PreparedStatement ps = con.prepareStatement(cmd);
			ps.setString(1, userId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String foodId = rs.getString("foodid");
				Food temp = new AdminDao().getFood(foodId);
				cart.put(temp, rs.getInt("quantity"));
			}
			return cart;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean deleteCart(Cart cart) {
		try {
			Connection con = DbUtil.getConnection();
			String cmd = "delete from cart where cartid = ? and foodid = ?";
			PreparedStatement ps = con.prepareStatement(cmd);
			ps.setString(1, cart.getCartId());
			ps.setString(2, cart.getFoodId());
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

	public boolean updateCart(Cart cart) {
		try {
			Connection con = DbUtil.getConnection();
			String cmd = "select quantity from cart where cartid = ? and foodid = ?";
			PreparedStatement ps = con.prepareStatement(cmd);
			ps.setString(1, cart.getCartId());
			ps.setString(2, cart.getFoodId());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				int quantity = rs.getInt("quantity");
				quantity += cart.getQuantity();
				cart.setQuantity(quantity);
			}
			Date d = new Date(cart.getOrderDate().getTime());
			cmd = "update cart set quantity=?, orderdate=? where cartid = ? and foodid = ?";
			ps = con.prepareStatement(cmd);
			ps.setString(3, cart.getCartId());
			ps.setString(4, cart.getFoodId());
			ps.setInt(1, cart.getQuantity());
			ps.setDate(2, d);
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

}
