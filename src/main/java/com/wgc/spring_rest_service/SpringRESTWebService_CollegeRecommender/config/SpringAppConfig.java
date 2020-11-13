package com.wgc.spring_rest_service.SpringRESTWebService_CollegeRecommender.config;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

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
        return new MongoClient(MONGODB_IP, MONGODB_PORT).getDatabase( MONGODB_DB_NAME);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
