package com.lazycece.sbac.exception.exception;

/**
 * @author lazycece
 */
public class GlobalException extends AbstractGlobalException {

    private Integer code;

    public GlobalException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public GlobalException(String message, Throwable cause, Integer code) {
        super(message, cause);
        this.code = code;
    }

    public GlobalException(Throwable cause, Integer code) {
        super(cause);
        this.code = code;
    }

    @Override
    public int getCode() {
        return this.code;
    }
}
