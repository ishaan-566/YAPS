package com.services;

import java.util.ArrayList;

import com.DAO.HomeDao;
import com.beans.Food;

public class HomeService {
	HomeDao hd = new HomeDao();

	public ArrayList<Food> getPizzas() {
		ArrayList<Food> pizzas = hd.getPizzas();
		return pizzas;
	}

	public ArrayList<Food> getBurgers() {
		ArrayList<Food> burgers = hd.getBurgers();
		return burgers;
	}

	public ArrayList<Food> getDrinks() {
		ArrayList<Food> drinks = hd.getDrinks();
		return drinks;
	}

	public ArrayList<Food> getPastas() {
		ArrayList<Food> pastas = hd.getPastas();
		return pastas;
	}
}
