package com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.service;

import com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.entity.Student;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    public boolean verify(String token) {
        return true;
    }

    public String sign(Student studnet) {
        return null;
    }
}
