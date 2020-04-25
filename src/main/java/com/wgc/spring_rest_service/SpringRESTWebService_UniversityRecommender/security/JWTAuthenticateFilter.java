package com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.security;

import org.springframework.security.authentication.AuthenticationManager;
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
        if(authorizationHeader != null && authorizationHeader.startsWith( JWTUtil.TOKEN_PREFIX)) {
            // this set Authentication to be a new one. So if the new one's authenticated = true, then it passes
            SecurityContextHolder.getContext().setAuthentication( JWTUtil.verifyAuthenticate( authorizationHeader.replace( JWTUtil.TOKEN_PREFIX, "")));
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
