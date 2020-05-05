package com.wgc.spring_rest_service.SpringRESTWebService_CollegeRecommender.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class CustomizedExceptionHandler {
    private static Logger logger = LoggerFactory.getLogger(CustomizedExceptionHandler.class);

    // only catch the exception we need to customize, and let Spring to handle all other Exceptions and log the exception info
    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<String> handle(Exception e) {
        logger.error("", e);
        MDC.clear();
        //                                        HttpStatus.INTERNAL_SERVER_ERROR,
        return new ResponseEntity("User-"+MDC.get("UserInfo")+" was not found", HttpStatus.BAD_REQUEST );
    }
}
