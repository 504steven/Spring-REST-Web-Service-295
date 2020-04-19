package com.example.designyourlife.controller;

import com.example.designyourlife.db.MongoDBConnection;
import com.example.designyourlife.entity.Survey;
import com.example.designyourlife.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/survey")
public class SurveyController {
    @Autowired
    private TokenService tokenService;

    @Autowired
    private MongoDBConnection mongoDBConnection;

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
