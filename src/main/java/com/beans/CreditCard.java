package com.beans;

import java.util.Date;

public class CreditCard {
	
	private int creditCardNumber;
	private String userId;
	private Date validTill;
	public CreditCard(int creditCardNumber, String userId, Date validTill) {
		super();
		this.creditCardNumber = creditCardNumber;
		this.userId = userId;
		this.validTill = validTill;
	}
	public CreditCard() {
		super();
	}
	public int getCreditCardNumber() {
		return creditCardNumber;
	}
	public void setCreditCardNumber(int creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getValidTill() {
		return validTill;
	}
	public void setValidTill(Date validTill) {
		this.validTill = validTill;
	}
	@Override
	public String toString() {
		return "CreditCard [creditCardNumber=" + creditCardNumber + ", userId=" + userId + ", validTill=" + validTill
				+ "]";
	}
	
	
	
}