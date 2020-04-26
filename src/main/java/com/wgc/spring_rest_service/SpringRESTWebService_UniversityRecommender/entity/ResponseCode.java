package com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.entity;

// !!!!!! Can be, but not used in the proj
// used as ResponseBody
public class ResponseCode {
    private Long code;
    private String msg;
    private Object data;

    public ResponseCode() {

    }

    public ResponseCode(Long code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static ResponseCode ok(String msg) {
        return new ResponseCode(200L, msg, null);
    }

    public static ResponseCode fail(String msg) {
        return new ResponseCode(500L, msg, null);
    }

    public static ResponseCode ok(String msg, Object data) {
        return new ResponseCode(200L, msg, data);
    }
}
