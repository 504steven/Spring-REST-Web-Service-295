package com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.entity.AppUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

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

    public static Authentication verifyAuthenticate(String token) {
        if(invalidTokenSet.contains(token)) {
            return null;
        }

        // can throws JWTVerificationException
        DecodedJWT deocodedJWT = JWT.require(HMAC512(SECRET.getBytes())).build().verify(token);
        if (deocodedJWT != null) {
            Claim claim = deocodedJWT.getClaim("Roles");
            String[] userRoles = claim.asArray(String.class);
            for(int i = 0; i < userRoles.length; i++) {
                userRoles[i] = "ROLE_" + userRoles[i];
            }

            //parse claim for role info into Authentication
            // must use 3-param constructor, it sets authenticated = true
            return new UsernamePasswordAuthenticationToken(deocodedJWT.getSubject(), null, AuthorityUtils.createAuthorityList(userRoles));
        } else {
            return null;
        }

    }

    public static String createTokenOnAppUser(AppUser appUserOnDB) {
        return JWT.create()
                .withSubject(appUserOnDB.getEmail())
                //store claim for role info to JWT token
                .withArrayClaim("Roles", appUserOnDB.getRoles().toArray(new String[0]))
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(HMAC512(SECRET.getBytes()));
    }

    public static void invalidToken(String token) {
        invalidTokenSet.add(token);
    }


    // used for LoginFilter, which is not used in the proj
    public static String createTokenOnAuth(Authentication auth) {
        User user = (User) auth.getPrincipal();
        return JWT.create()
                .withSubject(user.getUsername())
                //todo:  store claim for role info to JWT token
//                .withArrayClaim("Roles", appUser.getRoles().toArray(new String[0]) )
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(HMAC512(SECRET.getBytes()));
    }
}
