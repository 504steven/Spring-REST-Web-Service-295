package com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class MySQLTableCreation {
    private static final String HOSTNAME = "localhost";
    private static final String PORT_NUM = "3306";
    public static final String DB_NAME = "designyourcollege";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    public static final String DB_URL = "jdbc:mysql://" + HOSTNAME + ":" + PORT_NUM ;

    public static void main(String[] args) {
        MySQLTableCreation mySQLTableCreation = new MySQLTableCreation();
        mySQLTableCreation.createDatabase();
        mySQLTableCreation.createTables();
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

    private void createTables() {
        try( Connection conn = DriverManager.getConnection(DB_URL + "/" + DB_NAME, USERNAME, PASSWORD)) {
            Statement stmt = conn.createStatement();

            //Create app_uer tables.
            String sql = "CREATE TABLE app_user " + "(userId INT unsigned AUTO_INCREMENT, " + " email VARCHAR(255) NOT NULL, " + " password VARCHAR(255) NOT NULL, "
                        + " lastName VARCHAR(255) NOT NULL, " + " firstName VARCHAR(255) NOT NULL, " + "gender VARCHAR(255), " + "status VARCHAR(255), "
                        + "currentID VARCHAR(255), " + "schoolName VARCHAR(255), "
                        + "age INT UNSIGNED, " + "gpa DECIMAL(3,2), " + "SAT_math INT UNSIGNED, " + "SAT_verbal INT UNSIGNED, " + "expense_limit INT UNSIGNED, "
                        + " PRIMARY KEY (userId), " + " INDEX (email))";
            stmt.executeUpdate(sql);

            //Create role tables.
            sql = "CREATE TABLE role " + "(userId INT unsigned, " + " role VARCHAR(255) NOT NULL, " + " FOREIGN KEY (userId) REFERENCES app_user( userId), " + " INDEX (userId), " + " INDEX (role))";
            stmt.executeUpdate(sql);

            // insert dummy data
            sql = "INSERT INTO app_user (email, password, lastName, firstName, age, gpa)" + "VALUES ( \"dummy@dummy.com\",\"dummy-pswd\", \"dummy-lastname\", \"dummy-firstname\", 0, 0.0)";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO role VALUES (1,\"Student\")";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO role VALUES (1,\"Admin\")";
            stmt.executeUpdate(sql);

            System.out.println("AppUser and Role tables are created Successfully.");
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("AppUser and Role tables are created Failed.");
        }
    }

}
