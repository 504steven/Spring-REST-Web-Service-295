package com.wgc.spring_rest_service.SpringRESTWebService_CollegeRecommender.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

// !!!!!! Can be, but not used in the proj, since we are letting Spring to catch all Exceptions and log the exception info
//@ControllerAdvice
public class CustomizedExceptionHandler {
    private static Logger logger = LoggerFactory.getLogger(CustomizedExceptionHandler.class);

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ResponseEntity<String> handle(Exception e) {
        logger.error(e.getMessage(), e);
        MDC.clear();
        //                                        HttpStatus.INTERNAL_SERVER_ERROR
        return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST );
    }
}
