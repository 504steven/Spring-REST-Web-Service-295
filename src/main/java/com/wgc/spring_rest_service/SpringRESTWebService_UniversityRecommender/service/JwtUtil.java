package com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.config.SpringSecurityConfig;
import com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.entity.Student;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class JwtUtil {

    public static Authentication verify(String token) {
        String user = null;
        // throws JWTVerificationException
        try{
            user = JWT.require(Algorithm.HMAC512(SpringSecurityConfig.SECRET.getBytes()))
                .build()
                .verify(token)
                .getSubject();
        }catch (Exception e) {

        }


        if (user != null) {
            UserDetailsServiceImpl userDetailsService;
//            return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
        }
        return null;
    }

    public String createToken() {
//        String token = JWT.create()
//                .withSubject(((User) auth.getPrincipal()).getUsername())
//                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
//                .sign(HMAC512(SECRET.getBytes()));
//        res.addHeader(HEADER_STRING, TOKEN_PREFIX + token);
        return null;
    }
}
