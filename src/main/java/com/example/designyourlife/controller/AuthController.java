package com.example.designyourlife.controller;

import com.example.designyourlife.db.StudentDao;
import com.example.designyourlife.service.TokenService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@Repository
@CrossOrigin("*")
@RequestMapping("/auth")
public class AuthController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TokenService tokenService;

    @Autowired
    private StudentDao studentDao;


    @PostMapping("/signup")
    public boolean signup(String username, String pswd) {
        return  true;
    }

    @GetMapping("/login")
    public boolean login(String username, String pswd) {
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
