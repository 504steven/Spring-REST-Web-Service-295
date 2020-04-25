package com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.config;

import com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.security.JWTVerifyAuthenticatieFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//import com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.security.UserDetailsServiceImpl;

@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    public static final String SECRET = "cmpe295";
    public static final long EXPIRATION_TIME = 1200_0000;  // unit: mill-second    // 86_400_000 : 1 day
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";

    private static final String[] AUTH_WHITELIST = {
            // -- swagger ui
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**",
            // other public endpoints of your API may be appended to this array
            "/user/signup",
            "/user/login",
    };

//    @Autowired
//    private UserDetailsServiceImpl userDetailsServiceImpl;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.cors().and().csrf().disable().authorizeRequests()
                .antMatchers(AUTH_WHITELIST).permitAll()
                .antMatchers("/user/admin").hasRole("Admin")
                .anyRequest()
                .authenticated()
//                .hasAnyRole("Role_Admin", "Role_Student")
                .and()
//                .addFilter( new LoginFilter(authenticationManager()))
                .addFilter(new JWTVerifyAuthenticatieFilter( authenticationManager()))
                .sessionManagement().sessionCreationPolicy( SessionCreationPolicy.STATELESS);
    }

        // Do not need "configure(AuthenticationManagerBuilder"
        // "/login" is do authentication with my own code
        // "JWTVerifyAuthentication" does not use UserDetailService to atuhenticate
//        @Override
//        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//            auth.userDetailsService(userDetailsServiceImpl).passwordEncoder( bCryptPasswordEncoder);
//        }
}


