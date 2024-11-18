package com.mohit.MongoSB.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import com.mohit.MongoSB.entity.ProductEntity;
import com.mohit.MongoSB.repository.ProductRepository;
import com.mohit.MongoSB.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{
	
	Logger log = LogManager.getLogger(ProductServiceImpl.class);

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public List<ProductEntity> findAllProducts() {
		return productRepository.findAll(Sort.by("productId"));
	}

	@Override
	public ProductEntity findProductById(String id) {
		Optional<ProductEntity> entity = productRepository.findById(id);
		return entity.get();
	}

	@Override
	public boolean addProduct(List<ProductEntity> products) {
		boolean success = true;
		for(ProductEntity product : products) {
			ProductEntity entity = productRepository.insert(product);
			success = success && ObjectUtils.isEmpty(entity) ? false : true;
		}
		return success;
	}

	@Override
	public boolean deleteProduct(String userId) {
		productRepository.deleteById(userId);
		return true;
	}
	//Only property in input object to be updated, rest must not be set to null
	@Override
	public boolean editProduct(List<ProductEntity> products) {
		boolean success = true;
		for(ProductEntity product : products) {
			ProductEntity entity = productRepository.save(product);
			success = success && ObjectUtils.isEmpty(entity) ? false : true;
		}
		return success;
	}
}
