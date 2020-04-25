package com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.entity;

import java.util.ArrayList;
import java.util.List;

public class AppUser{
    private int userId;
    private String email;       // userdetails.User username
    private String password;
    private String firstName;
    private String lastName;
    private List<String> roles = new ArrayList<>();     // user can be in different roles/groups

    private String gender;
    private String status;
    private String schoolName;
    // school id
    private String currentId;
    private int age;
    private double gpa;
    private int SAT_math;
    private int SAT_verbal;
    private int expense_limit;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
    public List<String> getRoles() {
        return roles;
    }


    // student filed
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getCurrentId() {
        return currentId;
    }

    public void setCurrentId(String currentId) {
        this.currentId = currentId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public int getSAT_math() {
        return SAT_math;
    }

    public void setSAT_math(int SAT_math) {
        this.SAT_math = SAT_math;
    }

    public int getSAT_verbal() {
        return SAT_verbal;
    }

    public void setSAT_verbal(int SAT_verbal) {
        this.SAT_verbal = SAT_verbal;
    }

    public int getExpense_limit() {
        return expense_limit;
    }

    public void setExpense_limit(int expense_limit) {
        this.expense_limit = expense_limit;
    }

}
