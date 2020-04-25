//package com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.security;
//
//import com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.db.AppUserDao;
//import com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.entity.AppUser;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//    @Autowired
//    AppUserDao appUserDao;
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        AppUser appUser = appUserDao.getAppUserByEmail(email);
//        String[] userRoles = appUser.getRoles().toArray( new String[0]);
////        AuthorityUtils.createAuthorityList(userRoles)
////        return new User(appUser.getEmail(), appUser.getPassword(), new ArrayList<>());
//        return new User("", "", new ArrayList<>());
//    }
//}
