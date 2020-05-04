package com.wgc.spring_rest_service.SpringRESTWebService_CollegeRecommender.config;

public class DBConfig {
    // MySQL
    public static final String MYSQL_IP = "localhost";
    public static final String MYSQL_PORT = "3306";
    public static final String MYSQL_USERNAME = "root";
    public static final String MYSQL_PASSWORD = "root";
    public static final String MYSQL_DB_URL = "jdbc:mysql://" + MYSQL_IP + ":" + MYSQL_PORT;
    public static final String MYSQL_DB_NAME = "designyourcollege";

    //MongoDB
    public static String MONGODB_IP = "localhost";
    public static int MONGODB_PORT = 27017;
    public static String MONGODB_DB_NAME = "designyourcollege";


}
