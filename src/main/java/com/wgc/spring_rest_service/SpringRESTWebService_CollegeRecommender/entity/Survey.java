package com.wgc.spring_rest_service.SpringRESTWebService_CollegeRecommender.entity;

import java.util.List;

public class Survey {
    private int id;
    private List<String> questions;
    private List<List<String>> options;
    private boolean inUse;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getQuestions() {
        return questions;
    }

    public void setQuestions(List<String> questions) {
        this.questions = questions;
    }

    public List<List<String>> getOptions() {
        return options;
    }

    public void setOptions(List<List<String>> options) {
        this.options = options;
    }

    public boolean isInUse() {
        return inUse;
    }

    public void setInUse(boolean inUse) {
        this.inUse = inUse;
    }
}
