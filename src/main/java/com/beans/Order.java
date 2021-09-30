package com.beans;

import java.util.Date;

public class Order {
	private String orderId;
	private String userId;
	private Date date;
	private String storeId;
	private int cartId;
	private String orderStatus;
	private String street;
	private String city;
	private int pincode;
	private int mobileNumber;
	
	public Order() {
		super();
	}

	public Order(String orderId, String userId, Date date, String storeId, int cartId, String orderStatus,
			String street, String city, int pincode, int mobileNumber) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.date = date;
		this.storeId = storeId;
		this.cartId = cartId;
		this.orderStatus = orderStatus;
		this.street = street;
		this.city = city;
		this.pincode = pincode;
		this.mobileNumber = mobileNumber;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public int getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(int mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", userId=" + userId + ", date=" + date + ", storeId=" + storeId
				+ ", cartId=" + cartId + ", orderStatus=" + orderStatus + ", street=" + street + ", city=" + city
				+ ", pincode=" + pincode + ", mobileNumber=" + mobileNumber + "]";
	}
	
	
	
}
