package com.beans;

import java.util.ArrayList;

public class PizzaStore {
	private String storeId;
	private String name;
	private long mobileNo;
	private String city;
	private String state;
	private String street;
	private int pincode;
	private ArrayList<String> Foods;
	
	public ArrayList<String> getFoods() {
		return Foods;
	}

	public void setFoods(ArrayList<String> foods) {
		Foods = foods;
	}

	public PizzaStore() {
		
	}

	public PizzaStore(String storeId, String name, long mobileNo, String city, String street, String state, int pincode) {
		super();
		this.storeId = storeId;
		this.name = name;
		this.mobileNo = mobileNo;
		this.city = city;
		this.street = street;
		this.state = state;
		this.pincode = pincode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "<td>" + storeId + "</td>"+
			   "<td>" + name + "</td>"+
			   "<td>" + mobileNo + "</td>";
	}
	
	
}
