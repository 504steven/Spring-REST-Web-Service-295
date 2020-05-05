package com.wgc.spring_rest_service.SpringRESTWebService_CollegeRecommender.controller;

import com.wgc.spring_rest_service.SpringRESTWebService_CollegeRecommender.db.AppUserDao;
import com.wgc.spring_rest_service.SpringRESTWebService_CollegeRecommender.entity.AppUser;
import com.wgc.spring_rest_service.SpringRESTWebService_CollegeRecommender.security.JWTUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Autowired
    private AppUserDao appUserDao;

    @PostMapping("/signup")
    public void  signup(HttpServletRequest req, @RequestBody AppUser appUser) {
        MDC.put("userInfo", "User-" + appUser.getEmail());
        logger.info(req.getRequestURI() + ": User is trying to sign up...");
        appUser.setPassword(bCryptPasswordEncoder.encode(appUser.getPassword()));
        appUserDao.saveAppUser(appUser);
        logger.info("User signed up successfully.");
        MDC.clear();
    }

    @PostMapping("/login")
    public ResponseEntity<AppUser> login(HttpServletRequest req, HttpServletResponse response, @RequestBody AppUser appUser) {
        MDC.put("userInfo", "User-" + appUser.getEmail());
        logger.info( req.getRequestURI() + ": User is trying to login...");
        AppUser appUserOnDB = appUserDao.getAppUserByEmail(appUser.getEmail());
        boolean validation = bCryptPasswordEncoder.matches(appUser.getPassword(), appUserOnDB.getPassword());
//        appUserOnDB.setPassword(null);
        if(validation) {
            response.addHeader( JWTUtil.HEADER_STRING, JWTUtil.TOKEN_PREFIX + JWTUtil.createTokenOnAppUser(appUserOnDB));
            logger.info("User logged in successfully.");
            MDC.clear();
            return new ResponseEntity<>(appUserOnDB, HttpStatus.OK);
        }else {
            logger.warn("User logged in failed, wrong username(email)-password.");
            MDC.clear();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/logout")
    public void logout(HttpServletRequest req, HttpServletRequest httpServletRequest, @RequestBody AppUser appUser) {
        MDC.put("userInfo", "User Id-" + appUser.getUserId());
        logger.info( req.getRequestURI() + ": User is trying to logout...");
        JWTUtil.verifyJWTwithUserId(req, appUser.getUserId());
        String authorizationHeader = httpServletRequest.getHeader( JWTUtil.HEADER_STRING);
        JWTUtil.invalidToken( authorizationHeader.replace( JWTUtil.TOKEN_PREFIX, ""));
        logger.info("User logged out successfully");
        MDC.clear();
    }

    @PutMapping("/profile")
    public void update(HttpServletRequest req,  @RequestBody AppUser appUser) {
        MDC.put("userInfo", "User Id-" + appUser.getUserId());
        logger.info(req.getRequestURI() + ": User is trying to update profile...");
        JWTUtil.verifyJWTwithUserId(req, appUser.getUserId());
        appUser.setPassword(bCryptPasswordEncoder.encode(appUser.getPassword()));
        appUserDao.updateAppUser(appUser);
        logger.info("User updated profile successfully.");
        MDC.clear();
    }

    @GetMapping("/admin")
    public boolean admin() {
        return true;
    }

    @PostMapping("/jwt")
    public boolean jwt() {
        return true;
    }

    @GetMapping("/testMySQLTransaction")
    public Object testMySQLTransaction() {
        appUserDao.transactonTest();
        return null;
    }
}
