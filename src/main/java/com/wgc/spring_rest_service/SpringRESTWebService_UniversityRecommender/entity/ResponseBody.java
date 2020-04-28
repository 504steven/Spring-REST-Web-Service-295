package com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.entity;

// !!!!!! Can be, but not used in the proj
public class ResponseBody {
    private Long code;
    private String msg;
    private Object data;

    public ResponseBody() {

    }

    public ResponseBody(Long code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static ResponseBody ok(String msg) {
        return new ResponseBody(200L, msg, null);
    }

    public static ResponseBody fail(String msg) {
        return new ResponseBody(500L, msg, null);
    }

    public static ResponseBody ok(String msg, Object data) {
        return new ResponseBody(200L, msg, data);
    }
}
