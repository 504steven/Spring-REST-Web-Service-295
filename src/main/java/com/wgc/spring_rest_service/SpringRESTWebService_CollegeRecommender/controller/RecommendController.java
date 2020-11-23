package com.wgc.spring_rest_service.SpringRESTWebService_CollegeRecommender.controller;

import com.wgc.spring_rest_service.SpringRESTWebService_CollegeRecommender.entity.AppUser;
import com.wgc.spring_rest_service.SpringRESTWebService_CollegeRecommender.entity.College;
import com.wgc.spring_rest_service.SpringRESTWebService_CollegeRecommender.security.JWTUtil;
import com.wgc.spring_rest_service.SpringRESTWebService_CollegeRecommender.service.RecommendationServiceCall;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping("/recommend")
public class RecommendController {
    private Logger logger = LoggerFactory.getLogger(RecommendController.class);

    @Autowired
    private RecommendationServiceCall recommendationServiceCall;

    @GetMapping("/college")
    public List<College> recommendUniversity(HttpServletRequest req, @RequestBody AppUser appUser) {
        MDC.put("userEmail", "User Email-" + appUser.getEmail());
        MDC.put("userId", "User Id -" + appUser.getUserId());
        logger.info( "{}: User is trying to get college recommendation...", req.getRequestURI());
        JWTUtil.verifyJWTwithUserId(req, appUser.getUserId());
        List<College> colleges = recommendationServiceCall.recommendUniversity(appUser.getUserId());
        logger.info("College Recommendation was performed successfully.");
        MDC.clear();
        return colleges;
    }

    @GetMapping("/major")
    public List<String> recommendMajor(HttpServletRequest req, @RequestBody AppUser appUser) {
        MDC.put("userEmail", "User Email-" + appUser.getEmail());
        MDC.put("userId", "User Id -" + appUser.getUserId());
        logger.info( "{}: User is trying to get major recommendation...", req.getRequestURI());
        JWTUtil.verifyJWTwithUserId(req, appUser.getUserId());
        logger.info("Major Recommendation was performed successfully.");
        return recommendationServiceCall.recommendMajor(appUser.getUserId());
    }
}
