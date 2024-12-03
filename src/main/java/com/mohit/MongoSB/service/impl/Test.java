package com.mohit.MongoSB.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import com.mohit.MongoSB.entity.ProductEntity;
import com.mohit.MongoSB.entity.UserOrderDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class Test {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<UserOrderDTO> getUserOrderDetails(Long userId) {
    	
        Aggregation aggregation = Aggregation.newAggregation(
            Aggregation.match(Criteria.where("userId").is(userId)),
            Aggregation.unwind("orderDetails"),
            Aggregation.lookup("products", "orderDetails.productId", "_id", "productDetails"),
            Aggregation.unwind("productDetails"),
            Aggregation.lookup("users", "userId", "_id", "userDetails"),
            Aggregation.unwind("userDetails"),
            Aggregation.project()
                .and("userDetails.name").as("userName")
                .and("userDetails.email").as("userEmail")
                .and("orderDetails.quantity").as("quantity")
                .and("productDetails.name").as("productName")
                .and("productDetails.description").as("productDescription")
                .and("productDetails.price").as("productPrice")
                .and("orderId").as("orderId")
                .and("totalPrice").as("totalPrice")
        );

        AggregationResults<Map> results = mongoTemplate.aggregate(aggregation, "userOrders", Map.class);
        List<Map> mappedResults = results.getMappedResults();

        Map<Object, List<Map>> groupedByOrderId = mappedResults.stream().collect(Collectors.groupingBy(result -> result.get("orderId")));

        List<UserOrderDTO> userOrderDetailsList = new ArrayList<>();

        for (Map.Entry<Object, List<Map>> entry : groupedByOrderId.entrySet()) {
            List<ProductEntity> productDetails = entry.getValue().stream().map(result -> {
            	ProductEntity productDetail = new ProductEntity();
                productDetail.setProductName((String) result.get("productName"));
                productDetail.setProductPrice((String) result.get("productPrice"));
                return productDetail;
            }).collect(Collectors.toList());

            UserOrderDTO userOrderDetail = new UserOrderDTO();
//            userOrderDetail.setUserName((String) entry.getValue().get(0).get("userName"));
//            userOrderDetail.setUserEmail((String) entry.getValue().get(0).get("userEmail"));
//            userOrderDetail.setProductDetails(productDetails);
//            userOrderDetail.setTotalPrice((Long) entry.getValue().get(0).get("totalPrice"));

            userOrderDetailsList.add(userOrderDetail);
        }

        return userOrderDetailsList;
    }
}
