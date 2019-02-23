package com.lazycece.sbac.exception.exception;

/**
 * @author lazycece
 * @date 2019/02/23
 */
public abstract class AbstractGlobalException extends RuntimeException {
    public AbstractGlobalException() {
    }

    public AbstractGlobalException(String message) {
        super(message);
    }

    public AbstractGlobalException(String message, Throwable cause) {
        super(message, cause);
    }

    public AbstractGlobalException(Throwable cause) {
        super(cause);
    }

    /**
     * global-custom-exception's code
     *
     * @return int
     */
    abstract public int getCode();
}
