package com.mohit.MongoSB.RestController;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mohit.MongoSB.entity.Orders;
import com.mohit.MongoSB.entity.UserOrderDTO;
import com.mohit.MongoSB.service.OrdersService;

@RestController
@RequestMapping("/orders")
public class OrdersController {

	Logger log = LogManager.getLogger(OrdersController.class);
	
	@Autowired
	OrdersService ordersService;
	
	@PostMapping("/logOrder")
	boolean logOrders(@RequestBody List<Orders> orders) {
		return ordersService.logOrder(orders);
	}
	
	@GetMapping("/orderByUser/{id}")
	List<UserOrderDTO> getOrdersByUser(@PathVariable("id") long userId) {
		return ordersService.getOrderByUser(userId);
	}
	
}
