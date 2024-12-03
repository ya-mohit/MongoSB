package com.mohit.MongoSB.entity;

import java.util.ArrayList;
import java.util.List;

public class UserOrderDTO {
	
	private String userId;
	private String orderDate;
	private UserEntity userDetails = null;
	private List<ProductEntity> productDetails = new ArrayList<>();
	private List<OrderItems> orderDetails = new ArrayList<>(); 
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public UserEntity getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(UserEntity userDetails) {
		this.userDetails = userDetails;
	}
	public List<ProductEntity> getProductDetails() {
		return productDetails;
	}
	public void setProductDetails(List<ProductEntity> productDetails) {
		this.productDetails = productDetails;
	}
	public List<OrderItems> getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(List<OrderItems> orderDetails) {
		this.orderDetails = orderDetails;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	
	@Override
	public String toString() {
		return "UserOrderDTO [userId=" + userId + ", orderDate=" + orderDate + ", userDetails=" + userDetails
				+ ", productDetails=" + productDetails + ", orderDetails=" + orderDetails + "]";
	}
}
