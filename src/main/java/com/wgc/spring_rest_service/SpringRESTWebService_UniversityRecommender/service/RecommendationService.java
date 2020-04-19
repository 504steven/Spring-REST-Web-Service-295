package com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.service;

import com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.db.StudentDao;
import com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.db.UniversityDao;
import com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.entity.University;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationService {
    @Autowired
    private StudentDao studentDao;

    @Autowired
    private UniversityDao universityDao;


    public List<University> recommendUniversity(int studentId) {
        return null;
    }

    public List<University> recommendMajor(int studentId) {
        return null;
    }
}
