package com.lazycece.sbac.response.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * define the common response body
 *
 * @author lazycece
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseData<T> {

    /**
     * the response code
     */
    private Integer status;
    /**
     * the response message
     */
    private String message;
    /**
     * the response body
     */
    private T body;

    /**
     * define success response data by default code and message, but no body
     *
     * @return response
     */
    public static ResponseData success() {
        return new ResponseData<>(ResponseCode.SUCCESS, ResponseMsg.SUCCESS, null);
    }

    /**
     * define success response data by default code and message, the body is flexible
     *
     * @param body body
     * @param <T>  T
     * @return response
     */
    public static <T> ResponseData<T> success(T body) {
        return new ResponseData<>(ResponseCode.SUCCESS, ResponseMsg.SUCCESS, body);
    }

    /**
     * define the fail response by default code and message
     *
     * @return response
     */
    public static ResponseData fail() {
        return new ResponseData<>(ResponseCode.FAIL, ResponseMsg.FAIL, null);
    }

    /**
     * define the fail response by default code, and the message is flexible
     *
     * @param message fail message
     * @return response
     */
    public static ResponseData fail(String message) {
        return new ResponseData<>(ResponseCode.FAIL, message, null);
    }

    /**
     * define the fail response, the code and message both flexible
     *
     * @param status  code
     * @param message message
     * @return response
     */
    public static ResponseData fail(Integer status, String message) {
        return new ResponseData<>(status, message, null);
    }
}