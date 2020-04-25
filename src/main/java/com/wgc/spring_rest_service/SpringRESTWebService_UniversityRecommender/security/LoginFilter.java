package com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// !!!!!! Can be, but not used in the proj
// - UsernamePasswordAuthenticationFilter is only responsible for an URL.  At default, it is /login
//   this way, it is doing authentication in Filter by Spring Security
// - another way to login is to implement authentication process ourselves by examining  user input
//   the user input can be any type, rather being restricted by Spring Security Authentication class
public class LoginFilter extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager authenticationManager;

    public LoginFilter(AuthenticationManager authenticationManager) {
        LoginFilter.super.setFilterProcessesUrl("/login");
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication( HttpServletRequest req,
                                                HttpServletResponse res) throws AuthenticationException {
        if ( !req.getMethod().equals("POST")) {
            throw new AuthenticationServiceException("Authentication method not supported: " + req.getMethod());
        }

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken("","");

        try {
            UserInfoFromRequestBody creds = new ObjectMapper().readValue(req.getInputStream(), UserInfoFromRequestBody.class);

            usernamePasswordAuthenticationToken =
                    new UsernamePasswordAuthenticationToken( creds.getEmail().trim(), creds.getPassword().trim());
        } catch (IOException e) {
            throw new AuthenticationServiceException("RequestBody Data not supported: " + e.getMessage());
        }finally {
            this.setDetails(req, usernamePasswordAuthenticationToken);
                 //  this method asks to use UserDetailsService to authenticate
            return this.authenticationManager.authenticate( usernamePasswordAuthenticationToken);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {
        String token = JWTUtil.createTokenOnAuth(auth);
        System.out.println("successful Authenticated, --- token : " + token);
        res.addHeader( JWTUtil.HEADER_STRING, JWTUtil.TOKEN_PREFIX + token);
    }
}

class UserInfoFromRequestBody{
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}