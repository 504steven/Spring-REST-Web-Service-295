package com.wgc.spring_rest_service.SpringRESTWebService_CollegeRecommender.service;

import com.wgc.spring_rest_service.SpringRESTWebService_CollegeRecommender.db.AppUserDao;
import com.wgc.spring_rest_service.SpringRESTWebService_CollegeRecommender.db.CollegeDao;
import com.wgc.spring_rest_service.SpringRESTWebService_CollegeRecommender.entity.College;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationService {
    @Autowired
    private AppUserDao appUserDao;

    @Autowired
    private CollegeDao collegeDao;


    public List<College> recommendUniversity(int studentId) {
        return null;
    }

    public List<College> recommendMajor(int studentId) {
        return null;
    }
}
