package com.wgc.spring_rest_service.SpringRESTWebService_CollegeRecommender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
public class SpringRestServiceCollegeRecommenderApp {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestServiceCollegeRecommenderApp.class, args);
	}
}