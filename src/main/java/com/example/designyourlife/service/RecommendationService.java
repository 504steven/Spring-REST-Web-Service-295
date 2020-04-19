package com.example.designyourlife.service;

import com.example.designyourlife.db.StudentDao;
import com.example.designyourlife.db.UniversityDao;
import com.example.designyourlife.entity.University;
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
