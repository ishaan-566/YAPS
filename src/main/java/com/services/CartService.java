package com.services;

import java.util.LinkedHashMap;

import com.DAO.CartDao;
import com.beans.Cart;
import com.beans.Food;

public class CartService {
	
	CartDao cd = new CartDao();
	
	public boolean addCart(Cart cart) {
		boolean flag = cd.addCart(cart);
		return flag;
	}
	
	public LinkedHashMap<Food, Integer> getCart(String userId) {
		LinkedHashMap<Food, Integer> cart = cd.getCart(userId);
		return cart;
	}

	public boolean deleteCart(Cart cart) {
		boolean flag = cd.deleteCart(cart);
		return flag;
	}

	public boolean updateCart(Cart cart) {
		boolean flag = cd.updateCart(cart);
		return flag;
	}
}
