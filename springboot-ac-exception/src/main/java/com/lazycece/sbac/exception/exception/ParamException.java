package com.lazycece.sbac.exception.exception;


import com.lazycece.sbac.exception.response.ResCode;

/**
 * @author lazycece
 */
public class ParamException extends AbstractGlobalException {
    public ParamException() {
    }

    public ParamException(String message) {
        super(message);
    }

    public ParamException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public int getCode() {
        return ResCode.PARAM_ERROR;
    }
}
