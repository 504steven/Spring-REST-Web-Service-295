package com.example.designyourlife.entity;

public class Student {
    private int id;
    private String name;
    private String gender;
    private int age;
    private int grade;
    private int satMath;
    private int satVerbal;
    private int expense_limit;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSatMath() {
        return satMath;
    }

    public void setSatMath(int satMath) {
        this.satMath = satMath;
    }

    public int getSatVerbal() {
        return satVerbal;
    }

    public void setSatVerbal(int satVerbal) {
        this.satVerbal = satVerbal;
    }

    public int getExpense_limit() {
        return expense_limit;
    }

    public void setExpense_limit(int expense_limit) {
        this.expense_limit = expense_limit;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
