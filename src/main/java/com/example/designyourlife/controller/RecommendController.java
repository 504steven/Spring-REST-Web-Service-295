package com.example.designyourlife.controller;

import com.example.designyourlife.db.MongoDBConnection;
import com.example.designyourlife.entity.University;
import com.example.designyourlife.service.RecommendationService;
import com.example.designyourlife.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Repository
@CrossOrigin("*")
@RequestMapping("/recommend")
public class RecommendController {
    @Autowired
    private TokenService tokenService;

    @Autowired
    private RecommendationService recommendationService;

    @Autowired
    private MongoDBConnection mongoDBConnection;

    @GetMapping("/university")
    public List<University> recommendUniversity(int studentId) {
        return recommendationService.recommendUniversity(studentId);
    }

}
