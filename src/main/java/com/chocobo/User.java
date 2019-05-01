package com.chocobo;

public class User {

	private String userType;
	private String productType;
	private int longTimeJoined;
	private String amount;
	
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public int getLongTimeJoined() {
		return longTimeJoined;
	}
	public void setLongTimeJoined(int longTimeJoined) {
		this.longTimeJoined = longTimeJoined;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
}
