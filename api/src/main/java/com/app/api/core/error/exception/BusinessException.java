package com.app.api.core.error.exception;

/**
 * 커스텀 예외 처리
 */
public class BusinessException extends RuntimeException {

    private ErrorCode errorCode;

    public BusinessException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public ErrorCode getStaticErrorCode (){
       return errorCode;
    }

}
