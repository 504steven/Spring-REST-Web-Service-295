package com.example.designyourlife;

import com.example.designyourlife.entity.ApplicationUser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper {
    public ApplicationUser findByUsername(String uname) {
        ApplicationUser au = new ApplicationUser();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/cmpe295?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","root");
//here sonoo is database name, root is username and password
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from login where username = '" + uname + "'");
            String password = "";
            while(rs.next())
                //System.out.println(rs.getInt(1)+"  "+rs.getString(2));
                password = rs.getString(2);
                au.setPassword(password);
                au.setUsername(uname);

            con.close();
        }catch(Exception e){
            System.out.println(e);
        }

        return au;
    }

    public List<ApplicationUser> getAll() {
        List<ApplicationUser> list = new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/cmpe295?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","qqjanet1010");
//here sonoo is database name, root is username and password
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from login");
            String password = "";
            String username = "";
            while(rs.next()) {
                //System.out.println(rs.getInt(1)+"  "+rs.getString(2));
                password = rs.getString(2);
                username = rs.getString(1);
                ApplicationUser au = new ApplicationUser();
                au.setPassword(password);
                au.setUsername(username);
                list.add(au);
            }
            con.close();
        }catch(Exception e){
            System.out.println(e);
        }

        return list;
    }


    public void register(ApplicationUser au) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/cmpe295?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","qqjanet1010");
//here sonoo is database name, root is username and password
            Statement stmt=con.createStatement();
            stmt.executeUpdate("insert into login (username, password) values (\"" + au.getUsername() + "\", \"" + au.getPassword() + "\")");
            con.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}