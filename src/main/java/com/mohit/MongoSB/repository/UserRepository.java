package com.mohit.MongoSB.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import com.mohit.MongoSB.entity.UserEntity;

public interface UserRepository extends MongoRepository<UserEntity, String>{

	@Query("{userId : ?0}")
	UserEntity findByUserId(long id);

	@Query(value = "{userId : ?0}", delete = true)
	UserEntity deleteByUserId(long userId);

	
}
