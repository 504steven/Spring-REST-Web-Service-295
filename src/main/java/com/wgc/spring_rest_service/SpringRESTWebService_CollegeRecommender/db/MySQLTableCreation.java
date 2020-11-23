package com.wgc.spring_rest_service.SpringRESTWebService_CollegeRecommender.db;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import static com.wgc.spring_rest_service.SpringRESTWebService_CollegeRecommender.config.DBConfig.*;

public class MySQLTableCreation {
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public static void main(String[] args) {
        MySQLTableCreation mySQLTableCreation = new MySQLTableCreation();
        mySQLTableCreation.createDatabase();
        mySQLTableCreation.createTables();
        mySQLTableCreation.getTestData();
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
                        + " lastName VARCHAR(255) NOT NULL, " + " firstName VARCHAR(255) NOT NULL, " + " gender VARCHAR(255), " + " status VARCHAR(255), "
                        + " currentId VARCHAR(255), " + " schoolName VARCHAR(255), "
                        + " age INT UNSIGNED, " + " gpa DECIMAL(3,2), " + " SAT_math INT UNSIGNED, " + " SAT_reading INT UNSIGNED, " + " SAT_writing INT UNSIGNED, " + " ACT INT UNSIGNED, " + " expense_limit INT UNSIGNED, "
                        + " PRIMARY KEY (userId), " + " UNIQUE (email), " + " INDEX (email))";
//            System.out.println(sql );
            stmt.executeUpdate(sql);

            //Create role tables.
            sql = "CREATE TABLE role " + "(userId INT unsigned, " + " role VARCHAR(255) NOT NULL, " + " FOREIGN KEY (userId) REFERENCES app_user( userId), " + " UNIQUE (userId, role), "+ " INDEX (userId), " + " INDEX (role))";
            stmt.executeUpdate(sql);

            // insert dummy data
            String testAdminPswd = bCryptPasswordEncoder.encode("admin");
            System.out.println("-------------------- test data : ");
            System.out.println("            ------------ email : admin@admin.com");
            System.out.println("            ------------ password : "+ testAdminPswd);

            sql = "INSERT INTO app_user (email, password, lastName, firstName, age, gpa)" + "VALUES ( \"admin@admin.com\", \"" + testAdminPswd
                    + "\", \"dummy-lastname\", \"dummy-firstname\", 0, 0.0)";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO role VALUES (1,\"Student\")";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO role VALUES (1,\"Admin\")";
            stmt.executeUpdate(sql);

            System.out.println("-----------   AppUser and Role tables are created Successfully.  -----------");
        }catch (Exception e) {
            e.printStackTrace();
            System.err.println("-----------    AppUser and Role tables are created Failed.   --------------");
        }
    }

    private void getTestData() {
        String USER_ID = "userId", EMAIL = "email", PASSWORD = "password", LASTNAME = "lastName", FIRSTNAME = "firstName"
                         , AGE = "age", GPA = "gpa", ROLE = "role";

        try( Connection conn = DriverManager.getConnection(MYSQL_DB_URL + "/" + MYSQL_DB_NAME, MYSQL_USERNAME, MYSQL_PASSWORD)) {
            Statement stmt = conn.createStatement();

            String sql = "SELECT * FROM app_user";
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("get test data from table-app_user : ");
            while(rs.next()) {
                System.out.println("    " + USER_ID + " : " + rs.getString("userId"));
                System.out.println("    " + EMAIL + " : " + rs.getString("email"));
                System.out.println("    " + PASSWORD + " : " + rs.getString("password"));
                System.out.println("    " + LASTNAME + " : " + rs.getString("lastName"));
                System.out.println("    " + FIRSTNAME + " : " + rs.getString("firstName"));
                System.out.println("    " + AGE + " : " + rs.getString("age"));
                System.out.println("    " + GPA + " : " + rs.getString("gpa"));
            }

            sql = "SELECT * FROM role";
            rs = stmt.executeQuery(sql);
            System.out.println("get test data from table-role : ");
            while(rs.next()) {
                System.out.println("    " + USER_ID + " : " + rs.getString("userId"));
                System.out.println("    " + ROLE + " : " + rs.getString("role"));
            }

            System.err.println("-----------    Retrieving data from AppUser and Role tables Succeeded.   --------------");
        }catch (Exception e) {
            e.printStackTrace();
            System.err.println("-----------    Retrieving data from AppUser and Role tables are Failed.   --------------");
        }

    }
}
