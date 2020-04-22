package com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.db;

import com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.entity.College;
import org.springframework.stereotype.Repository;

@Repository
public class CollegeDao {

    public boolean saveUniversity(College college) {
        return true;
    }

    public boolean updateUniversity(College college) {
        return true;
    }

    public College getUniversity(int universityId) {
        return null;
    }
}
