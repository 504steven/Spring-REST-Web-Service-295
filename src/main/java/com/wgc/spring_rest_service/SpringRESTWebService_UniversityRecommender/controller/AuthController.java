package com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.controller;

import com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.db.AppUserDao;
import com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.entity.AppUser;
import com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.security.JWTUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class AuthController {
    private Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Autowired
    private AppUserDao appUserDao;

    @PostMapping("/signup")
    public void  signup(@RequestBody AppUser appUser) {
        MDC.put("email", "User-" + appUser.getEmail());
        logger.info("User is trying to sign up...");
        appUser.setPassword(bCryptPasswordEncoder.encode(appUser.getPassword()));
        appUserDao.saveAppUser(appUser);
        logger.info("User signed up successfully.");
        MDC.clear();
    }

    @PostMapping("/login")
    public ResponseEntity<AppUser> login(HttpServletResponse response, @RequestBody AppUser appUser) {
        MDC.put("email", "User-" + appUser.getEmail());
        logger.info("User is trying to login...");
        AppUser appUserOnDB = appUserDao.getAppUserByEmail(appUser.getEmail());
        boolean validation = bCryptPasswordEncoder.matches(appUser.getPassword(), appUserOnDB.getPassword());
        appUserOnDB.setPassword(null);
        if(validation) {
            response.addHeader( JWTUtil.HEADER_STRING, JWTUtil.TOKEN_PREFIX + JWTUtil.createTokenOnAppUser(appUserOnDB));
            logger.info("User logged in successfully.");
            MDC.clear();
            return new ResponseEntity<>(appUserOnDB, HttpStatus.OK);
        }else {
            logger.warn("User logged in failed, wrong email-password.");
            MDC.clear();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/logout")
    public boolean logout(HttpServletRequest httpServletRequest, AppUser appUser) {
        MDC.put("email", "User-" + appUser.getEmail());
        logger.info("User is trying to logout...");
        String authorizationHeader = httpServletRequest.getHeader( JWTUtil.HEADER_STRING);
        JWTUtil.invalidToken( authorizationHeader.replace( JWTUtil.TOKEN_PREFIX, ""));
        logger.warn("User logged out successfully");
        MDC.clear();
        return true;
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
