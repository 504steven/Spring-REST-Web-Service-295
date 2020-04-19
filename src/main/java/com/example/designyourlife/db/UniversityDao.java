package com.example.designyourlife.db;

import com.example.designyourlife.entity.University;
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
