package com.mohit.MongoSB.RestController;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mohit.MongoSB.entity.ProductEntity;
import com.mohit.MongoSB.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	Logger log = LogManager.getLogger(ProductController.class);

	@Autowired
	ProductService productService;

	@GetMapping("/")
	public List<ProductEntity> getAllRroducts() {
		log.info("request to list all Products");
		return productService.findAllProducts();
	}
	
	@GetMapping("/{id}")
	public ProductEntity getProductById(@PathVariable("id") String id) {
		return productService.findProductById(id);
	}
	
	@PostMapping("/addProduct")
	public boolean addUser(@RequestBody List<ProductEntity> products) {
		return productService.addProduct(products);
	}
	
	@PostMapping("/deleteProduct")
	public boolean deleteUser(@RequestParam("productId") String userId) {
		return productService.deleteProduct(userId);
	}
	
	@PutMapping("/editProduct")
	public boolean editUser(@RequestBody List<ProductEntity> products) {
		return productService.editProduct(products);
	}
}
