package com.mohit.MongoSB.service;

import java.util.List;

import com.mohit.MongoSB.entity.UserEntity;

public interface UserService {
	
	List<UserEntity> findAllUsers();

	List<UserEntity> findUserById(long id);

	boolean addUser(List<UserEntity> users);

	boolean deleteUser(long userId);

	boolean editUser(List<UserEntity> user);
}
