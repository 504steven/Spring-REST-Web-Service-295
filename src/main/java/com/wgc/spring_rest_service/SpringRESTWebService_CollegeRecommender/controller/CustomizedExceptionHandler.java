package com.wgc.spring_rest_service.SpringRESTWebService_CollegeRecommender.controller;


import com.auth0.jwt.exceptions.TokenExpiredException;
import com.mysql.cj.exceptions.WrongArgumentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


// only catch the exception we need to customize, and let Spring to handle all other Exceptions and log the exception info
@ControllerAdvice
public class CustomizedExceptionHandler {
    private static Logger logger = LoggerFactory.getLogger(CustomizedExceptionHandler.class);

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<String> handleEmptyResultDataAccessException(Exception e) {
        logger.error("", e);
        MDC.clear();
        //                                                                   HttpStatus.INTERNAL_SERVER_ERROR,
        return new ResponseEntity("Result was not found", HttpStatus.BAD_REQUEST );
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseEntity<String> handleDuplicateKeyException(Exception e) {
        logger.error("", e);
        MDC.clear();
        //                                                                   HttpStatus.INTERNAL_SERVER_ERROR,
        return new ResponseEntity( "Duplicated Key", HttpStatus.BAD_REQUEST );
    }

    @ExceptionHandler(WrongArgumentException.class)
    public ResponseEntity<String> handleWrongArgumentException(Exception e) {
        logger.error("", e);
        MDC.clear();
        //                                                                   HttpStatus.INTERNAL_SERVER_ERROR,
        return new ResponseEntity(  "Wrong Password", HttpStatus.BAD_REQUEST );
    }
}
