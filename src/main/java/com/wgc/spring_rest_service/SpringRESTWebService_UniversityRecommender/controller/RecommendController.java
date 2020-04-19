package com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.controller;

import com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.db.MongoDBConnection;
import com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.entity.University;
import com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.service.RecommendationService;
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
    private RecommendationService recommendationService;

    @Autowired
    private MongoDBConnection mongoDBConnection;

    @GetMapping("/university")
    public List<University> recommendUniversity(int studentId) {
        return null;
    }

}
