package com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.controller;

import com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.entity.Survey;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/survey")
public class SurveyController {

    public List<String> getSurveyList() {
        return null;
    }

    public Survey getSurveyById(int id) {
        return null;
    }

    public boolean addSurvey(Survey survey) {
        return true;
    }

    public boolean updateSurvey(Survey survey) {
        return true;
    }

}
