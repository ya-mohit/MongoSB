package com.mohit.MongoSB.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mohit.MongoSB.entity.Orders;

public interface OrdersRepository extends MongoRepository<Orders, String>{

	
}
