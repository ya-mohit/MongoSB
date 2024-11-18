package com.mohit.MongoSB.service;

import java.util.List;

import com.mohit.MongoSB.entity.ProductEntity;

public interface ProductService {

	List<ProductEntity> findAllProducts();

	ProductEntity findProductById(String id);

	boolean addProduct(List<ProductEntity> products);

	boolean deleteProduct(String userId);

	boolean editProduct(List<ProductEntity> user);

}
