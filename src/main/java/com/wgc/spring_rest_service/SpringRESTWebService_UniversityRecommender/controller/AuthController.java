package com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.controller;


import com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.db.StudentDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin("*")
public class AuthController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private StudentDao studentDao;


    @PostMapping("/signup")
    public boolean signup(String username, String pswd) {
        return  true;
    }

    @GetMapping("/login")
    public boolean login(HttpServletRequest httpServletRequest) {
        return  true;
    }

    @GetMapping("/logout")
    public boolean logout(String username) {
        return true;
    }

    @GetMapping("/testMySQL")
    public Object testMySQL() {
//        logger.info("test API");
        studentDao.saveStudentTest();
        return null;
    }

    @GetMapping("/testMySQLTransaction")
    public Object testMySQLTransaction() {
        studentDao.transactonTest();
        return null;
    }

    @ExceptionHandler(Exception.class)
    public Object handle(Exception e) {
//        logger.error("catch " + e.getMessage());
        return null;
    }
}
