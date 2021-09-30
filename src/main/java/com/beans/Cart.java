package com.beans;

import java.util.Date;

public class Cart {
	private String cartId;
	private String userId;
	private String foodId;
	private int quantity;
	private Date orderDate;
	public Cart() {
		super();
	}
	public String getCartId() {
		return cartId;
	}
	public void setCartId(String cartId) {
		this.cartId = cartId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFoodId() {
		return foodId;
	}
	public void setFoodId(String foodId) {
		this.foodId = foodId;
	}
	public Cart(String cartId, String userId, String foodId, int quantity, Date orderDate) {
		super();
		this.cartId = cartId;
		this.userId = userId;
		this.foodId = foodId;
		this.quantity = quantity;
		this.orderDate = orderDate;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", userId=" + userId + ", foodId=" + foodId + ", quantity="
				+ quantity + "orderDate=" + orderDate + "]";
	}
	
	
}
