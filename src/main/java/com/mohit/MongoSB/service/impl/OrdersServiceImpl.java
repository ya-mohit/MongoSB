package com.mohit.MongoSB.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mohit.MongoSB.entity.Orders;
import com.mohit.MongoSB.repository.OrdersRepository;
import com.mohit.MongoSB.service.OrdersService;

@Service
public class OrdersServiceImpl implements OrdersService{

	@Autowired
	OrdersRepository ordersRepository;
	
	@Override
	public boolean logOrder(List<Orders> orders) {
		ordersRepository.saveAll(orders);
		return true;
	}

	
	
	
}
