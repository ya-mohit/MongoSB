package com.mohit.MongoSB;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@Configuration
public class JndiMongoConfig {

	@Bean
	public MongoClient mongoClient() throws NamingException {
		Context context = (Context) new InitialContext().lookup("java:comp/env");
		String uri = (String) context.lookup("MONGODB_URI");				//To be matched in server.xml
		ConnectionString connectionString = new ConnectionString(uri);
		MongoClient client = MongoClients.create(connectionString);
		return client;
	}

	@Bean
	public MongoTemplate mongoTemplate(MongoClient mongoClient) {
		return new MongoTemplate(mongoClient, "springBoot"); // Specify your database name here
	}
	
	//server.xml ->
	//<Environment name="MONGODB_URI" override="false" type="java.lang.String" 
	//value="mongodb+srv://USER:PASSWORD@cluster0.tsoxa.mongodb.net/DATABASENAME?retryWrites=true&amp;w=majority&amp;appName=CLUSTERNAME"/>
	
	
}