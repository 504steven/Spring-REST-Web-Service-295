package com.wgc.spring_rest_service.SpringRESTWebService_CollegeRecommender.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.wgc.spring_rest_service.SpringRESTWebService_CollegeRecommender.entity.AppUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;

public class JWTUtil {
    public static final String SECRET = "cmpe295";
    public static final long EXPIRATION_TIME = 1200_000;  // unit: mill-second. 20min    // 86_400_000 : 1 day
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    private static Logger logger = LoggerFactory.getLogger(JWTUtil.class);
    private static Set<String> invalidTokenSet = new HashSet<>();

    public static void verifyJWTwithUserId(HttpServletRequest req, int userId) {
        String decodedUserId =  (String)req.getAttribute("userId");
        if( !decodedUserId.equals( Integer.toString(userId))) {
            logger.error("user sent Wrong JWT or Wrong UserId.");
            throw new AccessDeniedException("---- Access Denied ----");
        }
    }

    public static DecodedJWT verify(String token) {
        if(invalidTokenSet.contains(token)) {
            return null;
        }

        // check if JWT is valid.  can throws JWTVerificationException
        return JWT.require(HMAC512(SECRET.getBytes())).build().verify(token);
    }

    public static String createTokenOnAppUser(AppUser appUserOnDB) {
        return JWT.create()
                .withSubject( Integer.toString( appUserOnDB.getUserId()))
                //store claim for role info to JWT token
                .withArrayClaim("Roles", appUserOnDB.getRoles().toArray(new String[0]))
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(HMAC512(SECRET.getBytes()));
    }

    public static void invalidateToken(String token) {
        invalidTokenSet.add(token);
    }


    // used for LoginFilter, which is not used in the proj
    public static String createTokenOnAuth(Authentication auth) {
        User user = (User) auth.getPrincipal();
        return JWT.create()
                .withSubject(user.getUsername())
//                .withArrayClaim("Roles", appUser.getRoles().toArray(new String[0]) )
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(HMAC512(SECRET.getBytes()));
    }
}
