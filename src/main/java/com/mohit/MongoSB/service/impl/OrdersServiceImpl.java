package com.mohit.MongoSB.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import com.mohit.MongoSB.entity.Orders;
import com.mohit.MongoSB.entity.UserOrderDTO;
import com.mohit.MongoSB.repository.OrdersRepository;
import com.mohit.MongoSB.service.OrdersService;

@Service
public class OrdersServiceImpl implements OrdersService{
	
	private static final Logger LOG = LogManager.getLogger(OrdersServiceImpl.class);

	@Autowired
	OrdersRepository ordersRepository;
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	@Override
	public boolean logOrder(List<Orders> orders) {
		ordersRepository.saveAll(orders);
		return true;
	}

	@Override
	public List<UserOrderDTO> getOrderByUser(long userId) {
		
		Aggregation aggregation = Aggregation.newAggregation(
					Aggregation.match(Criteria.where("userId").is(userId)),
					Aggregation.lookup("users", "userId", "_id", "userDetails"),
					Aggregation.lookup("Products", "orderDetails.productId", "_id", "productDetails"),
					Aggregation.unwind("userDetails")
				);
		
		AggregationResults<UserOrderDTO> orderDTOs = mongoTemplate.aggregate(aggregation, "UserOrders", UserOrderDTO.class);
		
		LOG.info("orderDTOs :: "+orderDTOs.getMappedResults());
		
		return orderDTOs.getMappedResults();
	}

}
