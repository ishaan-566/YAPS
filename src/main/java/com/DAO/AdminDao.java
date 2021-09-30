package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.beans.Food;
import com.beans.PizzaStore;
import com.beans.UserCredentials;
import com.util.DbUtil;
public class AdminDao {

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

	public boolean add(UserCredentials user) {
		try {
			Connection con = DbUtil.getConnection();
			String cmd = "insert into usercredentials values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(cmd);
			ps.setString(1, user.getUserId());
			ps.setString(2, user.getPassword());
			ps.setString(3, "admin");
			ps.setInt(4, 0);
			int n = ps.executeUpdate();
			if(n>=1)
				return true;
			return false;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public ArrayList<UserCredentials> getAdmin() {
		try {
			ArrayList<UserCredentials> admin = new ArrayList<UserCredentials>();
			Connection con = DbUtil.getConnection();
			String cmd = "select * from usercredentials where usertype='admin'";
			PreparedStatement ps = con.prepareStatement(cmd);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				UserCredentials temp = new UserCredentials();
				temp.setUserId(rs.getString("userid"));
				temp.setPassword(rs.getString("password"));
				temp.setUserType(rs.getString("usertype"));
				if(rs.getInt("loginstatus") == 1)
					temp.setLoginStatus(true);
				else
					temp.setLoginStatus(false);
				admin.add(temp);
			}
			return admin;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean delete(UserCredentials user) {
		try {
			Connection con = DbUtil.getConnection();
			String cmd = "delete usercredentials where userid=?";
			PreparedStatement ps = con.prepareStatement(cmd);
			ps.setString(1, user.getUserId());
			int n = ps.executeUpdate();
			if(n>=1)
				return true;
			return false;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean add(Food dish) {
		try {
			Connection con = DbUtil.getConnection();
			String cmd = "insert into food values(?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(cmd);
			ps.setString(1, dish.getFoodId());
			ps.setString(2, dish.getName());
			ps.setString(3, dish.getType());
			ps.setString(4, dish.getDescription());
			ps.setInt(5, dish.getPrice());
			ps.setString(6, dish.getImage());
			int n = ps.executeUpdate();
			if(n>=1)
				return true;
			return false;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public ArrayList<Food> getDishes() {
		try {
			ArrayList<Food> dishes = new ArrayList<Food>();
			Connection con = DbUtil.getConnection();
			String cmd = "select * from food";
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
				dishes.add(temp);
			}
			return dishes;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean delete(Food food) {
		try {
			Connection con = DbUtil.getConnection();
			String cmd = "delete food where foodid=?";
			PreparedStatement ps = con.prepareStatement(cmd);
			ps.setString(1, food.getFoodId());
			int n = ps.executeUpdate();
			if(n>=1)
				return true;
			return false;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Food food) {
		try {
			Connection con = DbUtil.getConnection();
			String cmd = "update food set "
					+ "name = ?, "
					+ "type = ?, "
					+ "image = ?, "
					+ "price = ?, "
					+ "description = ? "
					+ "where foodid=?";
			PreparedStatement ps = con.prepareStatement(cmd);
			ps.setString(1, food.getName());
			ps.setString(2, food.getType());
			ps.setString(3, food.getImage());
			ps.setInt(4, food.getPrice());
			ps.setString(5, food.getDescription());
			ps.setString(6, food.getFoodId());
			int n = ps.executeUpdate();
			if(n>=1)
				return true;
			return false;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Food getFood(String foodId) {
		try {
			Connection con = DbUtil.getConnection();
			String cmd = "select * from food where foodid=?";
			PreparedStatement ps = con.prepareStatement(cmd);
			ps.setString(1, foodId);
			ResultSet rs = ps.executeQuery();
			Food food = new Food();
			if(rs.next()) {
				food.setFoodId(rs.getString("foodid"));
				food.setDescription(rs.getString("description"));
				food.setImage(rs.getString("image"));
				food.setName(rs.getString("name"));
				food.setPrice(rs.getInt("price"));
				food.setType(rs.getString("type"));
			}
			return food;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<PizzaStore> getStores() {
		try {
			ArrayList<PizzaStore> stores = new ArrayList<PizzaStore>();
			Connection con = DbUtil.getConnection();
			String cmd = "select * from pizzastore";
			PreparedStatement ps = con.prepareStatement(cmd);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				PizzaStore temp = new PizzaStore();
				temp.setStoreId(rs.getString("storeid"));
				temp.setName(rs.getString("name"));
				temp.setState(rs.getString("state"));
				temp.setStreet(rs.getString("street"));
				temp.setMobileNo(rs.getLong("mobileno"));
				temp.setCity(rs.getString("city"));
				temp.setPincode(rs.getInt("pincode"));
				stores.add(temp);
			}
			return stores;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean add(PizzaStore store) {
		try {
			Connection con = DbUtil.getConnection();
			String cmd = "insert into pizzastore values(?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(cmd);
			ps.setString(1, store.getStoreId());
			ps.setString(2, store.getName());
			ps.setString(3, store.getStreet());
			ps.setLong(4, store.getMobileNo());
			ps.setString(5, store.getCity());
			ps.setString(6, store.getState());
			ps.setInt(7, store.getPincode());
			int n = ps.executeUpdate();
			if(n>=1)
				return true;
			return false;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(PizzaStore store) {
		try {
			Connection con = DbUtil.getConnection();
			String cmd = "delete pizzastore where storeid=?";
			PreparedStatement ps = con.prepareStatement(cmd);
			ps.setString(1, store.getStoreId());
			int n = ps.executeUpdate();
			if(n>=1)
				return true;
			return false;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(PizzaStore store) {
		try {
			Connection con = DbUtil.getConnection();
			String cmd = "update pizzastore set name = ?, street = ?,  mobileno = ?, city = ?, state = ?, pincode = ? where storeid=?";
			PreparedStatement ps = con.prepareStatement(cmd);
			ps.setString(1, store.getName());
			ps.setString(2, store.getStreet());
			ps.setLong(3, store.getMobileNo());
			ps.setString(4, store.getCity());
			ps.setString(5, store.getState());
			ps.setInt(6, store.getPincode());
			ps.setString(7, store.getStoreId());
			int n = ps.executeUpdate();
			if(n>=1)
				return true;
			return false;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public PizzaStore getStore(String storeId) {
		try {
			Connection con = DbUtil.getConnection();
			String cmd = "select * from pizzastore food where storeid=?";
			PreparedStatement ps = con.prepareStatement(cmd);
			ps.setString(1, storeId);
			ResultSet rs = ps.executeQuery();
			PizzaStore temp = new PizzaStore();
			if(rs.next()) {
				temp.setStoreId(rs.getString("storeid"));
				temp.setName(rs.getString("name"));
				temp.setState(rs.getString("state"));
				temp.setStreet(rs.getString("street"));
				temp.setMobileNo(rs.getLong("mobileno"));
				temp.setCity(rs.getString("city"));
				temp.setPincode(rs.getInt("pincode"));
			}
			return temp;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
