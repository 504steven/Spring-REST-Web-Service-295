package com.wgc.spring_rest_service.SpringRESTWebService_CollegeRecommender.config;

public class DBConfig {
    // MySQL
    public static final String MYSQL_IP = "ec2-18-223-126-29.us-east-2.compute.amazonaws.com";
    public static final String MYSQL_PORT = "3306";
    public static final String MYSQL_USERNAME = "seer";
    public static final String MYSQL_PASSWORD = "seer";
    public static final String MYSQL_DB_URL = "jdbc:mysql://" + MYSQL_IP + ":" + MYSQL_PORT;
    public static final String MYSQL_DB_NAME = "designyourcollege";

    //MongoDB
    public static String MONGODB_IP = "ec2-18-223-126-29.us-east-2.compute.amazonaws.com";
    public static int MONGODB_PORT = 27017;
    public static String MONGODB_DB_NAME = "designyourcollege";
    public static String COLLEGE_COLLECTION = "colleges";
    public static final String MONGODB_USERNAME = "seer";
    public static final String MONGODB_PASSWORD = "seer";
}
