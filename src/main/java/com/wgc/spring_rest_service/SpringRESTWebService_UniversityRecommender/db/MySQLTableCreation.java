package com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import static com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.config.DBConfig.*;

public class MySQLTableCreation {

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
        try( Connection conn = DriverManager.getConnection(MYSQL_DB_URL, MYSQL_USERNAME, MYSQL_PASSWORD)) {
            // Import java.sql.Statement. Not com.mysql.jdbc.Statement.
            Statement stmt = conn.createStatement();
            String sql = "DROP DATABASE IF EXISTS " + MYSQL_DB_NAME;
            stmt.executeUpdate(sql);

            sql = "Create DATABASE " + MYSQL_DB_NAME;
            stmt.executeUpdate(sql);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createTables() {
        try( Connection conn = DriverManager.getConnection(MYSQL_DB_URL + "/" + MYSQL_DB_NAME, MYSQL_USERNAME, MYSQL_PASSWORD)) {
            Statement stmt = conn.createStatement();

            //Create app_uer tables.
            // auto column must be defined as a key
            String sql = "CREATE TABLE app_user " + "(userId INT unsigned AUTO_INCREMENT, " + " email VARCHAR(255) NOT NULL, " + " password VARCHAR(255) NOT NULL, "
                        + " lastName VARCHAR(255) NOT NULL, " + " firstName VARCHAR(255) NOT NULL, " + "gender VARCHAR(255), " + "status VARCHAR(255), "
                        + "currentId VARCHAR(255), " + "schoolName VARCHAR(255), "
                        + "age INT UNSIGNED, " + "gpa DECIMAL(3,2), " + "SAT_math INT UNSIGNED, " + "SAT_reading INT UNSIGNED, " + "SAT_writingINT UNSIGNED, " + "ACT INT UNSIGNED, " + "expense_limit INT UNSIGNED, "
                        + " PRIMARY KEY (userId), " + "UNIQUE (email), " + " INDEX (email))";
            stmt.executeUpdate(sql);

            //Create role tables.
            sql = "CREATE TABLE role " + "(userId INT unsigned, " + " role VARCHAR(255) NOT NULL, " + " FOREIGN KEY (userId) REFERENCES app_user( userId), " + " UNIQUE (userId, role), "+ " INDEX (userId), " + " INDEX (role))";
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
