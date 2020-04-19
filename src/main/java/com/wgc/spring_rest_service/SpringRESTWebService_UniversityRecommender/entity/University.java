package com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.entity;


public class University {
    private String name;   //def-instance
    private String state;
    private String control;
    private String location;
    private String percent_admittance;
    private String percent_enrolled;
    private String no_applicants;
    private String sat_verbal;
    private String sat_math;
    private String expenses;    // per semester
    private String percent_financial_aid;
    private String male_female_ratio;
    private String academics_scale;   // 1-5
    private String social_scale; //1-5
    private String quality_of_life_scale; //1-5

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getControl() {
        return control;
    }

    public void setControl(String control) {
        this.control = control;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPercent_admittance() {
        return percent_admittance;
    }

    public void setPercent_admittance(String percent_admittance) {
        this.percent_admittance = percent_admittance;
    }

    public String getPercent_enrolled() {
        return percent_enrolled;
    }

    public void setPercent_enrolled(String percent_enrolled) {
        this.percent_enrolled = percent_enrolled;
    }

    public String getNo_applicants() {
        return no_applicants;
    }

    public void setNo_applicants(String no_applicants) {
        this.no_applicants = no_applicants;
    }

    public String getSat_verbal() {
        return sat_verbal;
    }

    public void setSat_verbal(String sat_verbal) {
        this.sat_verbal = sat_verbal;
    }

    public String getSat_math() {
        return sat_math;
    }

    public void setSat_math(String sat_math) {
        this.sat_math = sat_math;
    }

    public String getExpenses() {
        return expenses;
    }

    public void setExpenses(String expenses) {
        this.expenses = expenses;
    }

    public String getPercent_financial_aid() {
        return percent_financial_aid;
    }

    public void setPercent_financial_aid(String percent_financial_aid) {
        this.percent_financial_aid = percent_financial_aid;
    }

    public String getMale_female_ratio() {
        return male_female_ratio;
    }

    public void setMale_female_ratio(String male_female_ratio) {
        this.male_female_ratio = male_female_ratio;
    }

    public String getAcademics_scale() {
        return academics_scale;
    }

    public void setAcademics_scale(String academics_scale) {
        this.academics_scale = academics_scale;
    }

    public String getSocial_scale() {
        return social_scale;
    }

    public void setSocial_scale(String social_scale) {
        this.social_scale = social_scale;
    }

    public String getQuality_of_life_scale() {
        return quality_of_life_scale;
    }

    public void setQuality_of_life_scale(String quality_of_life_scale) {
        this.quality_of_life_scale = quality_of_life_scale;
    }
}
