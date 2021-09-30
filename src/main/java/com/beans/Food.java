package com.beans;

public class Food {
	private String foodId;
	private String name;
	private String type;
	private String description;
	private int price;
	private String image;
	
	public Food(String foodId, String name, String type, String description, int price, String image) {
		super();
		this.foodId = foodId;
		this.name = name;
		this.type = type;
		this.description = description;
		this.price = price;
		this.image = image;
	}
	public Food() {
		
	}
	public String getFoodId() {
		return foodId;
	}
	public void setFoodId(String foodId) {
		this.foodId = foodId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "<td>" + foodId + "</td>"+
				   "<td>" + name + "</td>"+
				   "<td>" + type + "</td>";
	}
	
	
}
