package com.mohit.MongoSB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class MongoSbApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoSbApplication.class, args);
	}

}
