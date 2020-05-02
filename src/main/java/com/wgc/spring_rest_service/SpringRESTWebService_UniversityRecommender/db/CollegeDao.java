package com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.db;

import com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.entity.College;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CollegeDao {

    public boolean saveCollege(College college) {
        return true;
    }

    public boolean updateCollege(College college) {
        return true;
    }

    public List<College> getCollegeList(List<Integer> collegeIdList) {
        return null;
    }

    public College getCollege(int collegeId) {
        return null;
    }
}
