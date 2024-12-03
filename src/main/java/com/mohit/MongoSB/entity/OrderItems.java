package com.mohit.MongoSB.entity;

public class OrderItems {
	
	private String productId;
	private String quantity;
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "OrderItems [productId=" + productId + ", quantity=" + quantity + "]";
	}
}