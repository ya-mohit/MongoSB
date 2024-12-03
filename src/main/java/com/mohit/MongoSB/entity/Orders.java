package com.mohit.MongoSB.entity;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="UserOrders")
public class Orders {

	@Id
	private long orderId;
	private List<OrderItems> orderDetails;
	private long userId;
	private long totalPrice;
	private String orderDate;
	
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(long totalPrice) {
		this.totalPrice = totalPrice;
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
		return "Orders [orderId=" + orderId + ", orderDetails=" + orderDetails + ", userId=" + userId + ", totalPrice="
				+ totalPrice + ", orderDate=" + orderDate + "]";
	}
}
