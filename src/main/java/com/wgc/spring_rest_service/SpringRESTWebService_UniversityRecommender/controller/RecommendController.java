package com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.controller;

import com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.db.MongoDBConnection;
import com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.entity.College;
import com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping("/recommend")
public class RecommendController {
    @Autowired
    private RecommendationService recommendationService;

    @Autowired
    private MongoDBConnection mongoDBConnection;

    @GetMapping("/university")
    public List<College> recommendUniversity(int studentId) {
        return null;
    }

}
