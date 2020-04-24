package com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.controller;


import com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.db.AppUserDao;
import com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.entity.AppUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("*")
public class AuthController {
    private Logger logger = LoggerFactory.getLogger(AuthController.class);
    
    @Autowired
    private AppUserDao appUserDao;

    @PostMapping("/signup")
    public void  signup(@RequestBody AppUser appUser) {
        logger.info("User-{} is trying to sign up...",appUser.getEmail());
        MDC.put("email", appUser.getEmail());
//        appUserDao.saveAppUser(appUser);
        logger.info("User-{} signed up successfully.", appUser.getEmail() );
        MDC.clear();
    }

    @PostMapping("/login")
    public ResponseEntity<AppUser> login(@RequestBody AppUser appUser) {
        return  null;
    }

    @GetMapping("/logout")
    public boolean logout(String username) {
        return true;
    }

    @GetMapping("/testMySQLTransaction")
    public Object testMySQLTransaction() {
        appUserDao.transactonTest();
        return null;
    }
}
