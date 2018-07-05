package com.sa.common;

public class BusinessException extends RuntimeException {
    /**
     *Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 6832695224568830049L;

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
