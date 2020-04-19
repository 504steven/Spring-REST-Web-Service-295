package com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.config;

import com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.service.JwtUtil;
import com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JWTAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @Autowired
    JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String authorizationHeader = httpServletRequest.getHeader(SpringSecurityConfig.HEADER_STRING);
        if(authorizationHeader != null && authorizationHeader.startsWith(SpringSecurityConfig.TOKEN_PREFIX)) {
            SecurityContextHolder.getContext().setAuthentication( JwtUtil.verify( authorizationHeader.replace( SpringSecurityConfig.TOKEN_PREFIX, "")));
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
