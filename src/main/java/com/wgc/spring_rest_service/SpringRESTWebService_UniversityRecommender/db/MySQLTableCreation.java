package com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.db;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class MySQLTableCreation {
    private static final String HOSTNAME = "localhost";
    private static final String PORT_NUM = "3306";
    public static final String DB_NAME = "designyourlife";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    public static final String DB_URL = "jdbc:mysql://" + HOSTNAME + ":" + PORT_NUM ;
//    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args) {
        MySQLTableCreation mySQLTableCreation = new MySQLTableCreation();
        mySQLTableCreation.createDatabase();
        mySQLTableCreation.createStudentTable();
    }

    private MySQLTableCreation() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createDatabase() {
        try( Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
            // Import java.sql.Statement. Not com.mysql.jdbc.Statement.
            Statement stmt = conn.createStatement();
            String sql = "DROP DATABASE IF EXISTS " + DB_NAME;
            stmt.executeUpdate(sql);

            sql = "Create DATABASE " + DB_NAME;
            stmt.executeUpdate(sql);
        }catch (Exception e) {
            e.printStackTrace();
//            logger.info("Created Database student Failed in MySQL");
        }
//        logger.info("Created Database student Successfully in MySQL");
    }

    private void createStudentTable() {
        try( Connection conn = DriverManager.getConnection(DB_URL + "/" + DB_NAME, USERNAME, PASSWORD)) {
            Statement stmt = conn.createStatement();

            //Create new tables.
            String sql = "CREATE TABLE student " + "(id INT unsigned AUTO_INCREMENT, " + " name VARCHAR(255), "
                        + "gender VARCHAR(255), " + "age INT unsigned, " + "grade INT unsigned, " + "sat_math INT unsigned, " + "sat_verbal INT unsigned, " + "expense_limit INT unsigned, "
                        + " PRIMARY KEY ( id ))";
            stmt.executeUpdate(sql);

            // insert dummy data
            sql = "INSERT INTO student (name, gender, age, grade)" + "VALUES ( \"dummy-name\", \"dummy-sex\", 0, 0)";
            System.out.println("Executing query:\n" + sql);
            stmt.executeUpdate(sql);

//            logger.info("student table is created Successfully.");
        }catch (Exception e) {
            e.printStackTrace();
//            logger.error("student table is created Failed.");
        }
    }

}
