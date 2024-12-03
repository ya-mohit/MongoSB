package com.mohit.MongoSB.service;

import java.util.List;

import com.mohit.MongoSB.entity.Orders;
import com.mohit.MongoSB.entity.UserOrderDTO;

public interface OrdersService {

	boolean logOrder(List<Orders> orders);

	List<UserOrderDTO> getOrderByUser(long userId);

}
