//package com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.controller;
//
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.core.Ordered;
//import org.springframework.core.annotation.AnnotationUtils;
//import org.springframework.core.annotation.Order;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
//
//@ControllerAdvice
//@Order(Ordered.LOWEST_PRECEDENCE)
//public class ExceptionHandle {
//    private static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);
//
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<String> handle(Exception e) {
//        // Check if the exception is handled by Spring with @ResponseStatus
////        ResponseStatus responseStatusAnnotation = AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class);
//////        HttpStatus httpStatus = AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class).code();
////
////        System.out.println("--------" +  AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) );
////        System.out.println("--------" + e.getMessage() );
////        if ( responseStatusAnnotation != null) {
////            return new ResponseEntity(e.getMessage(), responseStatusAnnotation.code());
////        }else {
////            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR );
////        }
////        return new ResponseEntity( );
//    }
//}
