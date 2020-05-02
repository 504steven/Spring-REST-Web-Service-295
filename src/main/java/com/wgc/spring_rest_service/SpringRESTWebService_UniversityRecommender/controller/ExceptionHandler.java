package com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

// !!!!!! Can be, but not used in the proj
//@ControllerAdvice
public class ExceptionHandler {
    private static Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ResponseEntity<String> handle(Exception e) {
                                                // HttpStatus.BAD_REQUEST
        logger.error(e.getMessage(), e);
        return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR );
    }
}
