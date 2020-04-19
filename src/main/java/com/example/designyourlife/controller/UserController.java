package com.example.designyourlife.controller;

import com.example.designyourlife.DatabaseHelper;
import com.example.designyourlife.entity.ApplicationUser;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private DatabaseHelper dbHelper;

    public UserController(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        // change to the main database
        dbHelper = new DatabaseHelper();
    }

    @PostMapping("/sign-up")
    public void signUp(@RequestBody ApplicationUser user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        // database save user with username and encoded password
        dbHelper.register(user);
    }

    @GetMapping
    public List<ApplicationUser> getUser() {
        // get all userinfo from main database, just simple usage
        return dbHelper.getAll();
    }
}