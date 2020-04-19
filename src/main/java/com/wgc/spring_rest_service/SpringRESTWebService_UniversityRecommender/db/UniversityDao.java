package com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.db;

import com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.entity.University;
import org.springframework.stereotype.Repository;

@Repository
public class UniversityDao {

    public boolean saveUniversity(University university) {
        return true;
    }

    public boolean updateUniversity(University university) {
        return true;
    }

    public University getUniversity(int universityId) {
        return null;
    }
}
