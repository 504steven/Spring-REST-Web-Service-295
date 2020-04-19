package com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class MySQLTableCreation {
    private static final String HOSTNAME = "localhost";
    private static final String PORT_NUM = "3306";
    public static final String DB_NAME = "designyouruniveristy";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    public static final String DB_URL = "jdbc:mysql://" + HOSTNAME + ":" + PORT_NUM ;

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
        }
    }

    private void createStudentTable() {
        try( Connection conn = DriverManager.getConnection(DB_URL + "/" + DB_NAME, USERNAME, PASSWORD)) {
            Statement stmt = conn.createStatement();

            //Create new tables.
            String sql = "CREATE TABLE student " + "(userId INT unsigned AUTO_INCREMENT, " + " email VARCHAR(255) NOT NULL, " + " password VARCHAR(255) NOT NULL, "
                        + " lastName VARCHAR(255) NOT NULL, " + " firstName VARCHAR(255) NOT NULL, " + "gender VARCHAR(255), " + "status VARCHAR(255), "
                        + "currentID VARCHAR(255), " + "schoolName VARCHAR(255), "
                        + "age INT UNSIGNED, " + "gpa DECIMAL(3,2), " + "SAT_math INT UNSIGNED, " + "SAT_verbal INT UNSIGNED, " + "expense_limit INT UNSIGNED, "
                        + " PRIMARY KEY (userId))";
            stmt.executeUpdate(sql);

            // insert dummy data
            sql = "INSERT INTO student (email, password, lastName, firstName, age, gpa)" + "VALUES ( \"dummy@dummy.com\",\"dummy-pswd\", \"dummy-lastname\", \"dummy-firstname\", 0, 0.0)";
            System.out.println("Executing query:\n" + sql);
            stmt.executeUpdate(sql);

//            logger.info("student table is created Successfully.");
        }catch (Exception e) {
            e.printStackTrace();
//            logger.error("student table is created Failed.");
        }
    }

}
