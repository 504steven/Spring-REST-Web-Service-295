package com.wgc.spring_rest_service.SpringRESTWebService_CollegeRecommender.controller;

import com.mysql.cj.exceptions.WrongArgumentException;
import com.wgc.spring_rest_service.SpringRESTWebService_CollegeRecommender.db.AppUserDao;
import com.wgc.spring_rest_service.SpringRESTWebService_CollegeRecommender.entity.AppUser;
import com.wgc.spring_rest_service.SpringRESTWebService_CollegeRecommender.security.JWTUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;


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
        MDC.put("userEmail", "User Email-" + appUser.getEmail());
        logger.info("{}: User is trying to sign up...", req.getRequestURI());
        appUser.setPassword(bCryptPasswordEncoder.encode(appUser.getPassword()));
        int userId = appUserDao.saveAppUser(appUser);

        MDC.put("userId", "User Id-" + userId);
        logger.info("User signed up successfully.");
        MDC.clear();
    }

    // ResponseEntity<AppUser>:  AppUser + status code
    @PostMapping("/login")
    public ResponseEntity<Object[]> login(HttpServletRequest req, HttpServletResponse response, @RequestBody AppUser appUser) {
        MDC.put("userEmail", "User Email-" + appUser.getEmail());
        logger.info( "{}: User is trying to login...", req.getRequestURI());
        AppUser appUserOnDB = appUserDao.getAppUserByEmail(appUser.getEmail());

        MDC.put("userId", "User Id-" + appUser.getUserId());
        boolean validation = bCryptPasswordEncoder.matches(appUser.getPassword(), appUserOnDB.getPassword());
//        appUserOnDB.setPassword(null);
        if(!validation) {
            throw new WrongArgumentException("Wrong password.");
        }
        response.addHeader( JWTUtil.HEADER_STRING, JWTUtil.TOKEN_PREFIX + JWTUtil.createTokenOnAppUser(appUserOnDB));
        logger.info("User logged in successfully.");
        MDC.clear();
        return new ResponseEntity<>(new Object[]{ appUserOnDB, JWTUtil.createTokenOnAppUser(appUserOnDB)}, HttpStatus.OK);
    }

    @PostMapping("/logout")
    public void logout(Authentication auth, HttpServletRequest req, HttpServletRequest httpServletRequest, @RequestBody AppUser appUser) {
//        System.out.println("-----xxxx debug-x--x");
//        System.out.println(auth.getName());
//        System.out.println(auth.getPrincipal().toString());
        MDC.put("userEmail", "User Email-" + appUser.getEmail());
        MDC.put("userId", "User Id -" + appUser.getUserId());
        logger.info( "{}: User is trying to logout...", req.getRequestURI());
        JWTUtil.verifyJWTwithUserId(req, appUser.getUserId());
        String authorizationHeader = httpServletRequest.getHeader( JWTUtil.HEADER_STRING);
        JWTUtil.invalidateToken( authorizationHeader.replace( JWTUtil.TOKEN_PREFIX, ""));
        logger.info("User logged out successfully");
        MDC.clear();
    }

    @PutMapping("/profile")
    public void update(Authentication auth, HttpServletRequest req, @RequestBody AppUser appUser) {
                                    // userId is fixed. email can be updated
        MDC.put("userId", "User Id -" + appUser.getUserId());
        logger.info("{}: User is trying to update profile...", req.getRequestURI());
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
    public Map jwt() {
        Map<String, Object> map = new HashMap<>();
        map.put("k", "v");
        map.put("n",1);
        map.put("user", new AppUser());
        return map;
    }

    @GetMapping("/testMySQLTransaction")
    public Object testMySQLTransaction() {
        appUserDao.transactonTest();
        return null;
    }
}
