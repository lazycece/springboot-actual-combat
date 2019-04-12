//package com.lazycece.sbac.redis;
//
//
///**
// * @author CC
// */
//public class RedisException extends RuntimeException {
//
//    private int code = GlobalResponseCode.SERVER_ERROR;
//
//    public RedisException(String message) {
//        super(message);
//    }
//
//    public RedisException(String message, int code) {
//        super(message);
//        this.code = code;
//    }
//
//    public RedisException(String message, Throwable cause, int code) {
//        super(message, cause);
//        this.code = code;
//    }
//
//    public RedisException(Throwable cause, int code) {
//        super(cause);
//        this.code = code;
//    }
//
//    public RedisException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, int code) {
//        super(message, cause, enableSuppression, writableStackTrace);
//        this.code = code;
//    }
//}
