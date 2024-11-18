package com.mohit.MongoSB.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mohit.MongoSB.entity.ProductEntity;

public interface ProductRepository extends MongoRepository<ProductEntity, String>{

}
