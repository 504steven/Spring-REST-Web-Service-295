package com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.controller;


import com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.db.AppUserDao;
import com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.entity.AppUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("*")
public class AuthController {
    private Logger logger = LoggerFactory.getLogger(AuthController.class);
    
    @Autowired
    private AppUserDao appUserDao;

    @PostMapping("/signup")
    public ResponseEntity<String>  signup(@RequestBody AppUser appUser) {
        appUserDao.saveAppUser(appUser);
        logger.info("User：" + appUser.getEmail() + " signed up successfully.");
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<AppUser> login(@RequestBody AppUser appUser) {
        return  null;
    }

    @GetMapping("/logout")
    public boolean logout(String username) {
        return true;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String>  handle(Exception e) {
        e.getClass();

        logger.error(e.getMessage());
        return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR );
    }

    @GetMapping("/testMySQLTransaction")
    public Object testMySQLTransaction() {
        appUserDao.transactonTest();
        return null;
    }
}
