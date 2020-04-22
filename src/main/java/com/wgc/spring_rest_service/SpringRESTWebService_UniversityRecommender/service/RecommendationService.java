package com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.service;

import com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.db.AppUserDao;
import com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.db.UniversityDao;
import com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.entity.College;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationService {
    @Autowired
    private AppUserDao appUserDao;

    @Autowired
    private UniversityDao universityDao;


    public List<College> recommendUniversity(int studentId) {
        return null;
    }

    public List<College> recommendMajor(int studentId) {
        return null;
    }
}
