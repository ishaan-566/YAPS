package com.services;

import java.util.ArrayList;

import com.DAO.AdminDao;
import com.beans.Food;
import com.beans.PizzaStore;
import com.beans.UserCredentials;

public class AdminService {
	AdminDao ad = new AdminDao();
	
	public boolean login(UserCredentials user) {
		boolean flag = ad.login(user);
		return flag;
	}

	public boolean add(UserCredentials user) {
		boolean flag = ad.add(user);
		return flag;
	}

	public ArrayList<UserCredentials> getAdmin() {
		ArrayList<UserCredentials> admin = ad.getAdmin();
		return admin;
	}

	public boolean delete(UserCredentials user) {
		boolean flag = ad.delete(user);
		return flag;
	}

	public boolean add(Food dish) {
		boolean flag = ad.add(dish);
		return flag;
	}

	public ArrayList<Food> getDishes() {
		ArrayList<Food> dishes = ad.getDishes();
		return dishes;
	}

	public boolean delete(Food food) {
		boolean flag = ad.delete(food);
		return flag;
	}

	public boolean update(Food food) {
		boolean flag = ad.update(food);
		return flag;
	}

	public Food getFood(String foodId) {
		Food food = ad.getFood(foodId);
		return food;
	}

	public ArrayList<PizzaStore> getStores() {
		ArrayList<PizzaStore> stores = ad.getStores();
		return stores;
	}

	public boolean add(PizzaStore store) {
		boolean flag = ad.add(store);
		return flag;
	}

	public boolean delete(PizzaStore store) {
		boolean flag = ad.delete(store);
		return flag;
	}

	public boolean update(PizzaStore store) {
		boolean flag = ad.update(store);
		return flag;
	}

	public PizzaStore getStore(String storeId) {
		PizzaStore store = ad.getStore(storeId);
		return store;
	}
}
