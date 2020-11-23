package com.wgc.spring_rest_service.SpringRESTWebService_CollegeRecommender.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;

import static com.wgc.spring_rest_service.SpringRESTWebService_CollegeRecommender.config.DBConfig.*;

@Configuration
@EnableTransactionManagement
public class SpringAppConfig {

    @Bean
    public DataSource getMysqlDataSource() {
        // dbcp connection pool
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl( MYSQL_DB_URL + "/" + MYSQL_DB_NAME);
        dataSource.setUsername(MYSQL_USERNAME);
        dataSource.setPassword(MYSQL_PASSWORD);
        return dataSource;
    }

    @Bean
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(getMysqlDataSource());
    }

    @Bean
    public MongoDatabase getMongoDatabase() {
        MongoClientURI mongoClientURI = new MongoClientURI("mongodb://"+ MONGODB_USERNAME +":"
                + MONGODB_PASSWORD + "@"+ MONGODB_IP +":"+ MONGODB_PORT+"/" + MONGODB_DB_NAME);
        return new MongoClient( mongoClientURI).getDatabase(MONGODB_DB_NAME);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
