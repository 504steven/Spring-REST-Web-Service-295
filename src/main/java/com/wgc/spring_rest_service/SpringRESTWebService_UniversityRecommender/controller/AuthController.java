package com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.controller;

import com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.config.SpringSecurityConfig;
import com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.db.AppUserDao;
import com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.entity.AppUser;
import com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.security.JWTUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

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
        logger.info("User-{} is trying to sign up...",appUser.getEmail());
        MDC.put("email", "User-" + appUser.getEmail());
        appUser.setPassword(bCryptPasswordEncoder.encode(appUser.getPassword()));
        appUserDao.saveAppUser(appUser);
        logger.info("User-{} signed up successfully.", appUser.getEmail() );
        MDC.clear();
    }

    @PostMapping("/login")
    public ResponseEntity<AppUser> login(HttpServletResponse response, @RequestBody AppUser appUser) {
        AppUser appUserOnDB = appUserDao.getAppUserByEmail(appUser.getEmail());
        boolean validation = bCryptPasswordEncoder.matches(appUser.getPassword(), appUserOnDB.getPassword());
//        boolean validation = appUser.getPassword().equals( appUserOnDB.getPassword());
        appUserOnDB.setPassword(null);
        if(validation) {
            response.addHeader( SpringSecurityConfig.HEADER_STRING, SpringSecurityConfig.TOKEN_PREFIX + JWTUtil.createTokenOnAppUser(appUserOnDB));
            return new ResponseEntity<>(appUserOnDB, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/logout")
    public boolean logout(String username) {
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
