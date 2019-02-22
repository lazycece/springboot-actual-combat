package com.lazycece.sbac.response.response;

import java.util.HashMap;

/**
 * @author lazycece
 */
public class ResponseMap extends HashMap<String, Object> {

    private ResponseMap(Integer status, String message) {
        this.put("status", status);
        this.put("message", message);
    }

    /**
     * define success response map on default code and message
     *
     * @return this
     */
    public static ResponseMap success() {
        return new ResponseMap(ResponseCode.SUCCESS, ResponseMsg.SUCCESS);
    }

    /**
     * define fail response map on default code and message
     *
     * @return this
     */
    public static ResponseMap fail() {
        return new ResponseMap(ResponseCode.FAIL, ResponseMsg.FAIL);
    }

    /**
     * define fail response map on default code
     *
     * @param message ""
     * @return this
     */
    public static ResponseMap fail(String message) {
        return new ResponseMap(ResponseCode.FAIL, message);
    }

    /**
     * define fail response map
     *
     * @param status  ""
     * @param message ""
     * @return this
     */
    public static ResponseMap fail(Integer status, String message) {
        return new ResponseMap(status, message);
    }

    /**
     * @param key   key
     * @param value value
     * @return this
     */
    public ResponseMap putting(String key, Object value) {
        this.put(key, value);
        return this;
    }
}
