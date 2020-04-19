package com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

//@SpringBootApplication
@SpringBootApplication(
		exclude = {
				MongoAutoConfiguration.class,
				MongoDataAutoConfiguration.class
		})
public class SpringRestWebServiceUniversityRecommenderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestWebServiceUniversityRecommenderApplication.class, args);
	}

}
