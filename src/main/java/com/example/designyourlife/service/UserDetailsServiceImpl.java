package com.example.designyourlife.service;

import com.example.designyourlife.DatabaseHelper;
import com.example.designyourlife.entity.ApplicationUser;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private DatabaseHelper dbHelper;

    public UserDetailsServiceImpl() {
        // change to the main database
        dbHelper = new DatabaseHelper();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // connect with db, get user information
        ApplicationUser applicationUser = dbHelper.findByUsername(username);
        if (applicationUser == null) {
            throw new UsernameNotFoundException(username);
        }
        // this user is from sping core, not the User object in designyourlife
        return new User(applicationUser.getUsername(), applicationUser.getPassword(), emptyList());
    }
}