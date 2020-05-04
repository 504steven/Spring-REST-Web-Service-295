package com.wgc.spring_rest_service.SpringRESTWebService_CollegeRecommender.entity;

import java.util.Date;
import java.util.List;

public class SurveyResult {
    private int userId;
    private int surveyId;
    private Date date;
    private List<String> results;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(int surveyId) {
        this.surveyId = surveyId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<String> getResults() {
        return results;
    }

    public void setResults(List<String> results) {
        this.results = results;
    }
}
