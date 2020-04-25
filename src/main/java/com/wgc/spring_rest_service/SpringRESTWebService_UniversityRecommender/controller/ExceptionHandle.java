package com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// !!!!!! Can be, but not used in the proj
//@ControllerAdvice
public class ExceptionHandle  {
    private static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handle(Exception e) {
                                                // HttpStatus.BAD_REQUEST
        return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR );
    }
}
