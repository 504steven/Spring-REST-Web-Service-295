package com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.config.SpringSecurityConfig;
import com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.entity.AppUser;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;

public class JWTUtil {
    private static Logger logger = LoggerFactory.getLogger( JWTUtil.class);

    public static Authentication verifyAuthenticate(String token) {
        DecodedJWT deocodedJWT  = null;
        // throws JWTVerificationException
        try{
            deocodedJWT = JWT.require(HMAC512(SpringSecurityConfig.SECRET.getBytes())).build().verify(token);
        }catch (Exception e) {
            logger.warn("invalid jwt token");
        }finally {
            if (deocodedJWT != null) {
                Claim claim = deocodedJWT.getClaim("Roles");
                System.out.println("claim----------" + claim.toString());
                String[] userRoles = claim.asArray(String.class);
                System.out.println("claim----------" + userRoles.length);
                System.out.println("claim----------" + userRoles[0]);
                //parse claim for role info into authenticaiton
                // must use 3-param constructor, it sets authenticated = true
                return new UsernamePasswordAuthenticationToken( deocodedJWT.getSubject(), null, AuthorityUtils.createAuthorityList(userRoles));
            }else {
                return null;
            }
        }
    }

    public static String createTokenOnAuth(Authentication auth) {
        User user = (User)auth.getPrincipal();
        return JWT.create()
                .withSubject( user.getUsername() )
                //todo:  store claim for role info to JWT token
//                .withArrayClaim("Roles", appUser.getRoles().toArray(new String[0]) )
                .withExpiresAt(new Date(System.currentTimeMillis() + SpringSecurityConfig.EXPIRATION_TIME))
                .sign( HMAC512( SpringSecurityConfig.SECRET.getBytes()));
    }

    public static String createTokenOnAppUser(AppUser appUserOnDB) {
        return JWT.create()
                .withSubject( appUserOnDB.getEmail() )
                //store claim for role info to JWT token
                .withArrayClaim("Roles", appUserOnDB.getRoles().toArray(new String[0]) )
                .withExpiresAt(new Date(System.currentTimeMillis() + SpringSecurityConfig.EXPIRATION_TIME))
                .sign( HMAC512( SpringSecurityConfig.SECRET.getBytes()));
    }
}
