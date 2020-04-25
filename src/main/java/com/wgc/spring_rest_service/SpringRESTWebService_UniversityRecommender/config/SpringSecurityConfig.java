package com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.config;

import com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.security.JWTAuthenticateFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//import com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.security.UserDetailsServiceImpl;

@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

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
//                .authenticated()      //  hasRole() or authenticated)(
                .hasAnyRole("Admin", "Student")
                .and()
//                .addFilter( new LoginFilter(authenticationManager()))
                .addFilter(new JWTAuthenticateFilter( authenticationManager()))
                .sessionManagement().sessionCreationPolicy( SessionCreationPolicy.STATELESS);
    }

        // used for LoginFilter to do authentication
//        @Override
//        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//            auth.userDetailsService(userDetailsServiceImpl).passwordEncoder( bCryptPasswordEncoder);
//        }
}


