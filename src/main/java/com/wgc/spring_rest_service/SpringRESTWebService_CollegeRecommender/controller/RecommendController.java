package com.wgc.spring_rest_service.SpringRESTWebService_CollegeRecommender.controller;

import com.wgc.spring_rest_service.SpringRESTWebService_CollegeRecommender.entity.College;
import com.wgc.spring_rest_service.SpringRESTWebService_CollegeRecommender.service.RecommendationService;
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

    @GetMapping("/university")
    public List<College> recommendUniversity(int studentId) {
        return null;
    }

}
