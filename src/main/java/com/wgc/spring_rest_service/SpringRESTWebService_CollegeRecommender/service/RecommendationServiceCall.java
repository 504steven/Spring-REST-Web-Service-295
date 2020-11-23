package com.wgc.spring_rest_service.SpringRESTWebService_CollegeRecommender.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wgc.spring_rest_service.SpringRESTWebService_CollegeRecommender.db.AppUserDao;
import com.wgc.spring_rest_service.SpringRESTWebService_CollegeRecommender.db.CollegeDao;
import com.wgc.spring_rest_service.SpringRESTWebService_CollegeRecommender.entity.AppUser;
import com.wgc.spring_rest_service.SpringRESTWebService_CollegeRecommender.entity.College;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class RecommendationServiceCall {
    // ML recommendation server
    public static final String ML_IP = "52.53.251.35";
    public static final String ML_PORT = "8080";
    ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private AppUserDao appUserDao;

    @Autowired
    private CollegeDao collegeDao;

    @Autowired
    RestTemplate restTemplate;


    public List<College> recommendUniversity(int studentId) {
        List<College> res = new LinkedList<>();
        AppUser appUser = appUserDao.getAppUserById(studentId);
        if(appUser == null ) { return res;}
        // read/math/writing/ACT
        String url = "http://" + ML_IP +":" + ML_PORT + "/school_predict/" + appUser.getSAT_reading() + "/" + appUser.getSAT_math()
                                                                            + "/" + appUser.getSAT_writing() + "/" + appUser.getACT();

        ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);
       List<Integer> collgeIds = (List<Integer>)response.getBody().get("school_id");
        if(collgeIds == null || collgeIds.size() == 0) { return res;}
        for(int id : collgeIds) {
            College college = collegeDao.findCollegeById( id);
            if(college != null) { res.add(college);}
        }
        return res;
    }

    public List<String> recommendMajor(int studentId) {
        List<String> res = new LinkedList<>();
        AppUser appUser = appUserDao.getAppUserById(studentId);
        if(appUser == null ) { return res;}
        // read/math/writing
        String url = "http://" + ML_IP +":" + ML_PORT + "/major_predict/" + appUser.getSAT_reading() + "/" + appUser.getSAT_math()
                                                                            + "/" + appUser.getSAT_writing();

        ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);
        List<String> majors = (List<String>)response.getBody().get("major");
        if(majors == null) { return res;}
        return majors;
    }
}
