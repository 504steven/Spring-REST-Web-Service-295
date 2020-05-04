package com.wgc.spring_rest_service.SpringRESTWebService_CollegeRecommender.security;

import com.wgc.spring_rest_service.SpringRESTWebService_CollegeRecommender.db.AppUserDao;
import com.wgc.spring_rest_service.SpringRESTWebService_CollegeRecommender.entity.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;

// !!!!!! Can be used for LoginFilter-UsernamePasswordAuthenticationFilter to authenticate user input, but not used in the proj
//@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    AppUserDao appUserDao;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AppUser appUser = appUserDao.getAppUserByEmail(email);
        String[] userRoles = appUser.getRoles().toArray( new String[0]);
//        AuthorityUtils.createAuthorityList(userRoles)
        return new User(appUser.getEmail(), appUser.getPassword(), new ArrayList<>());
    }
}
