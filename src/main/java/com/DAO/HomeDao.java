package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.beans.Food;
import com.util.DbUtil;

public class HomeDao {
	public ArrayList<Food> getPizzas() {
		try {
			ArrayList<Food> pizzas = new ArrayList<Food>();
			Connection con = DbUtil.getConnection();
			String cmd = "select * from food where type='Pizza'";
			PreparedStatement ps = con.prepareStatement(cmd);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Food temp = new Food();
				temp.setFoodId(rs.getString("foodid"));
				temp.setDescription(rs.getString("description"));
				temp.setImage(rs.getString("image"));
				temp.setName(rs.getString("name"));
				temp.setPrice(rs.getInt("price"));
				temp.setType(rs.getString("type"));
				pizzas.add(temp);
			}
			return pizzas;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<Food> getBurgers() {
		try {
			ArrayList<Food> burgers = new ArrayList<Food>();
			Connection con = DbUtil.getConnection();
			String cmd = "select * from food where type='Burger'";
			PreparedStatement ps = con.prepareStatement(cmd);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Food temp = new Food();
				temp.setFoodId(rs.getString("foodid"));
				temp.setDescription(rs.getString("description"));
				temp.setImage(rs.getString("image"));
				temp.setName(rs.getString("name"));
				temp.setPrice(rs.getInt("price"));
				temp.setType(rs.getString("type"));
				burgers.add(temp);
			}
			return burgers;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<Food> getDrinks() {
		try {
			ArrayList<Food> drinks = new ArrayList<Food>();
			Connection con = DbUtil.getConnection();
			String cmd = "select * from food where type='Drink'";
			PreparedStatement ps = con.prepareStatement(cmd);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Food temp = new Food();
				temp.setFoodId(rs.getString("foodid"));
				temp.setDescription(rs.getString("description"));
				temp.setImage(rs.getString("image"));
				temp.setName(rs.getString("name"));
				temp.setPrice(rs.getInt("price"));
				temp.setType(rs.getString("type"));
				drinks.add(temp);
			}
			return drinks;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<Food> getPastas() {
		try {
			ArrayList<Food> pastas = new ArrayList<Food>();
			Connection con = DbUtil.getConnection();
			String cmd = "select * from food where type='Pasta'";
			PreparedStatement ps = con.prepareStatement(cmd);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Food temp = new Food();
				temp.setFoodId(rs.getString("foodid"));
				temp.setDescription(rs.getString("description"));
				temp.setImage(rs.getString("image"));
				temp.setName(rs.getString("name"));
				temp.setPrice(rs.getInt("price"));
				temp.setType(rs.getString("type"));
				pastas.add(temp);
			}
			return pastas;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
