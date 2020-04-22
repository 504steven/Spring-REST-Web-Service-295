package com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.controller;


import com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.db.AppUserDao;
import com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.entity.AppUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("*")
public class AuthController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private AppUserDao appUserDao;

    @PostMapping("/signup")
    public boolean signup(String username, String pswd) {
        return  true;
    }

//    @GetMapping("/login")
//    public AppUser login() {
//        return  null;
//    }

    @GetMapping("/logout")
    public boolean logout(String username) {
        return true;
    }

    @GetMapping("/testMySQL")
    public Object testMySQL() {
//        logger.info("test API");
        appUserDao.saveStudentTest();
        return null;
    }

    @GetMapping("/testMySQLTransaction")
    public Object testMySQLTransaction() {
        appUserDao.transactonTest();
        return null;
    }

    @ExceptionHandler(Exception.class)
    public Object handle(Exception e) {
//        logger.error("catch " + e.getMessage());
        return null;
    }
}
