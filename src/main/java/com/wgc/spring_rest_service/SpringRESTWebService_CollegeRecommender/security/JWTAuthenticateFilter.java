package com.wgc.spring_rest_service.SpringRESTWebService_CollegeRecommender.security;

import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JWTAuthenticateFilter extends BasicAuthenticationFilter {

    public JWTAuthenticateFilter(AuthenticationManager authManager) {
        super(authManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {
        String authorizationHeader = httpServletRequest.getHeader( JWTUtil.HEADER_STRING);
        UsernamePasswordAuthenticationToken auth = null;
        if(authorizationHeader != null && authorizationHeader.startsWith( JWTUtil.TOKEN_PREFIX)) {
            DecodedJWT decodedJWT = JWTUtil.verify( authorizationHeader.replace( JWTUtil.TOKEN_PREFIX, ""));
            if(decodedJWT != null) {
                Claim claim = decodedJWT.getClaim("Roles");
                String[] userRoles = claim.asArray(String.class);
                for(int i = 0; i < userRoles.length; i++) {
                    userRoles[i] = "ROLE_" + userRoles[i];
                }
                //parse claim of role info into Authentication
                // must use 3-param constructor, it sets authenticated = true
                auth = new UsernamePasswordAuthenticationToken(decodedJWT.getSubject(), null, AuthorityUtils.createAuthorityList(userRoles));

                // store decoded userId in request attribute, in case the URL request need it to check if JWT belongs to the request user
                httpServletRequest.setAttribute("userId", decodedJWT.getSubject());
            }
        }
        // this set Authentication to be a new one. So if the new one's authenticated = true, then it passes
        SecurityContextHolder.getContext().setAuthentication( auth);
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}

