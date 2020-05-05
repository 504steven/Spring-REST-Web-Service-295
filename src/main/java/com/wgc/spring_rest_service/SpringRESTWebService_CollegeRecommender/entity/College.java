package com.wgc.spring_rest_service.SpringRESTWebService_CollegeRecommender.entity;

import io.swagger.annotations.ApiModel;

@ApiModel
public class College {
    private int id;
    private String name;
    private double lon;
    private double lat;
    private String state;
    private String control;
    private String urbanization;
    private String religious_affiliation;
    private boolean offers_associate_degree;
    private boolean offers_bachelor_degree;
    private boolean offers_master_degree;
    private boolean offers_doctor_degree_research_scholarship;
    private boolean offers_doctor_degree_professional_practice;
    private int tuition_and_fees;
    private int applicants_total;
    private int admissions_total;
    private int enrolled_total;
    private int percent_admitted_total;
    private int total_enrollment;
    private int undergraduate_total_enrollment;
    private int graduate_total_enrollment;
    private int sat_reading_25th_percentile_score;
    private int sat_reading_75th_percentile_score;
    private int sat_math_25th_percentile_score;
    private int sat_math_75th_percentile_score;
    private int sat_writing_25th_percentile_score;
    private int sat_writing_75th_percentile_score;
    private int act_25th_percentile_score;
    private int act_75th_percentile_score;

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

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
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

    public String getUrbanization() {
        return urbanization;
    }

    public void setUrbanization(String urbanization) {
        this.urbanization = urbanization;
    }

    public String getReligious_affiliation() {
        return religious_affiliation;
    }

    public void setReligious_affiliation(String religious_affiliation) {
        this.religious_affiliation = religious_affiliation;
    }

    public boolean isOffers_associate_degree() {
        return offers_associate_degree;
    }

    public void setOffers_associate_degree(boolean offers_associate_degree) {
        this.offers_associate_degree = offers_associate_degree;
    }

    public boolean isOffers_bachelor_degree() {
        return offers_bachelor_degree;
    }

    public void setOffers_bachelor_degree(boolean offers_bachelor_degree) {
        this.offers_bachelor_degree = offers_bachelor_degree;
    }

    public boolean isOffers_master_degree() {
        return offers_master_degree;
    }

    public void setOffers_master_degree(boolean offers_master_degree) {
        this.offers_master_degree = offers_master_degree;
    }

    public boolean isOffers_doctor_degree_research_scholarship() {
        return offers_doctor_degree_research_scholarship;
    }

    public void setOffers_doctor_degree_research_scholarship(boolean offers_doctor_degree_research_scholarship) {
        this.offers_doctor_degree_research_scholarship = offers_doctor_degree_research_scholarship;
    }

    public boolean isOffers_doctor_degree_professional_practice() {
        return offers_doctor_degree_professional_practice;
    }

    public void setOffers_doctor_degree_professional_practice(boolean offers_doctor_degree_professional_practice) {
        this.offers_doctor_degree_professional_practice = offers_doctor_degree_professional_practice;
    }

    public int getApplicants_total() {
        return applicants_total;
    }

    public void setApplicants_total(int applicants_total) {
        this.applicants_total = applicants_total;
    }

    public int getAdmissions_total() {
        return admissions_total;
    }

    public void setAdmissions_total(int admissions_total) {
        this.admissions_total = admissions_total;
    }

    public int getEnrolled_total() {
        return enrolled_total;
    }

    public void setEnrolled_total(int enrolled_total) {
        this.enrolled_total = enrolled_total;
    }

    public int getPercent_admitted_total() {
        return percent_admitted_total;
    }

    public void setPercent_admitted_total(int percent_admitted_total) {
        this.percent_admitted_total = percent_admitted_total;
    }

    public int getTotal_enrollment() {
        return total_enrollment;
    }

    public void setTotal_enrollment(int total_enrollment) {
        this.total_enrollment = total_enrollment;
    }

    public int getUndergraduate_total_enrollment() {
        return undergraduate_total_enrollment;
    }

    public void setUndergraduate_total_enrollment(int undergraduate_total_enrollment) {
        this.undergraduate_total_enrollment = undergraduate_total_enrollment;
    }

    public int getGraduate_total_enrollment() {
        return graduate_total_enrollment;
    }

    public void setGraduate_total_enrollment(int graduate_total_enrollment) {
        this.graduate_total_enrollment = graduate_total_enrollment;
    }

    public int getTuition_and_fees() {
        return tuition_and_fees;
    }

    public void setTuition_and_fees(int tuition_and_fees) {
        this.tuition_and_fees = tuition_and_fees;
    }

    public int getSat_reading_25th_percentile_score() {
        return sat_reading_25th_percentile_score;
    }

    public void setSat_reading_25th_percentile_score(int sat_reading_25th_percentile_score) {
        this.sat_reading_25th_percentile_score = sat_reading_25th_percentile_score;
    }

    public int getSat_reading_75th_percentile_score() {
        return sat_reading_75th_percentile_score;
    }

    public void setSat_reading_75th_percentile_score(int sat_reading_75th_percentile_score) {
        this.sat_reading_75th_percentile_score = sat_reading_75th_percentile_score;
    }

    public int getSat_math_25th_percentile_score() {
        return sat_math_25th_percentile_score;
    }

    public void setSat_math_25th_percentile_score(int sat_math_25th_percentile_score) {
        this.sat_math_25th_percentile_score = sat_math_25th_percentile_score;
    }

    public int getSat_math_75th_percentile_score() {
        return sat_math_75th_percentile_score;
    }

    public void setSat_math_75th_percentile_score(int sat_math_75th_percentile_score) {
        this.sat_math_75th_percentile_score = sat_math_75th_percentile_score;
    }

    public int getSat_writing_25th_percentile_score() {
        return sat_writing_25th_percentile_score;
    }

    public void setSat_writing_25th_percentile_score(int sat_writing_25th_percentile_score) {
        this.sat_writing_25th_percentile_score = sat_writing_25th_percentile_score;
    }

    public int getSat_writing_75th_percentile_score() {
        return sat_writing_75th_percentile_score;
    }

    public void setSat_writing_75th_percentile_score(int sat_writing_75th_percentile_score) {
        this.sat_writing_75th_percentile_score = sat_writing_75th_percentile_score;
    }

    public int getAct_25th_percentile_score() {
        return act_25th_percentile_score;
    }

    public void setAct_25th_percentile_score(int act_25th_percentile_score) {
        this.act_25th_percentile_score = act_25th_percentile_score;
    }

    public int getAct_75th_percentile_score() {
        return act_75th_percentile_score;
    }

    public void setAct_75th_percentile_score(int act_75th_percentile_score) {
        this.act_75th_percentile_score = act_75th_percentile_score;
    }
}
