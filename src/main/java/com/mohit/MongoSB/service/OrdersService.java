package com.mohit.MongoSB.service;

import java.util.List;

import com.mohit.MongoSB.entity.Orders;

public interface OrdersService {

	boolean logOrder(List<Orders> orders);

}
