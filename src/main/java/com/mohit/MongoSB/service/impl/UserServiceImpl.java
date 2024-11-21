package com.mohit.MongoSB.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mohit.MongoSB.entity.UserEntity;
import com.mohit.MongoSB.repository.UserRepository;
import com.mohit.MongoSB.service.UserService;

import io.micrometer.common.util.StringUtils;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public List<UserEntity> findUserById(long id) {
		
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(1));
		List<UserEntity> users = mongoTemplate.find(query, UserEntity.class, "users");
		System.out.println("Query result: " + users);

		return users; //userRepository.findByUserId(id);
	}

	@Override
	public List<UserEntity> findAllUsers() {
		return userRepository.findAll(Sort.by("userId"));
	}

	@Override
	public boolean addUser(List<UserEntity> users) {
		boolean success = true;
		for(UserEntity user : users) {
			UserEntity userSaved = userRepository.insert(user);
			success = success && StringUtils.isEmpty(userSaved.getEmail()) ? false : true;
		}
		return success;	
	}

	@Override
	public boolean deleteUser(long userId) {
		UserEntity user = userRepository.deleteByUserId(userId);
		return StringUtils.isEmpty(user.getEmail()) ? false : true;
	}

	@Override
	public boolean editUser(List<UserEntity> users) {
		boolean success = true;
		for(UserEntity user : users) {
			UserEntity userEdited = userRepository.save(user);
			success = success && StringUtils.isEmpty(userEdited.getEmail()) ? false : true;
		}
		return success;
	}
}
