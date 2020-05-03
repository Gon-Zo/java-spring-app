package com.app.api.core.error;

import com.app.api.core.error.exception.BusinessException;
import com.app.api.core.error.exception.ErrorCode;
import com.app.api.core.error.exception.ErrorDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.nio.file.AccessDeniedException;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorDto handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {

        log.error(e.getMessage());
        log.error(ExceptionUtils.getStackTrace(e));

        return ErrorDto.builder()
                .errorCode(ErrorCode.INVALID_INPUT_VALUE.getCode())
                .errorMsg(ErrorCode.INVALID_INPUT_VALUE.getMessage())
                .errorDetail(ExceptionUtils.getStackTrace(e))
                .build();

    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorDto handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {

        log.error(e.getMessage());
        log.error(ExceptionUtils.getStackTrace(e));

        return ErrorDto.builder()
                .errorCode(ErrorCode.BAD_REQUEST.getCode())
                .errorMsg(ErrorCode.BAD_REQUEST.getMessage())
                .errorDetail(ExceptionUtils.getStackTrace(e))
                .build();

    }

    /**
     * 지원하지 않은 HTTP method 호출 할 경우 발생
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ErrorDto handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {

        log.error(e.getMessage());
        log.error(ExceptionUtils.getStackTrace(e));

        return ErrorDto.builder()
                .errorCode(ErrorCode.METHOD_NOT_ALLOWED.getCode())
                .errorMsg(ErrorCode.METHOD_NOT_ALLOWED.getMessage())
                .errorDetail(ExceptionUtils.getStackTrace(e))
                .build();
    }

    /**
     * Authentication 객체가 필요한 권한을 보유하지 않은 경우 발생합
     */
    @ExceptionHandler(AccessDeniedException.class)
    public ErrorDto handleAccessDeniedException(AccessDeniedException e) {

        log.error(e.getMessage());
        log.error(ExceptionUtils.getStackTrace(e));

        return ErrorDto.builder()
                .errorCode(ErrorCode.HANDLE_ACCESS_DENIED.getCode())
                .errorMsg(ErrorCode.HANDLE_ACCESS_DENIED.getMessage())
                .errorDetail(ExceptionUtils.getStackTrace(e))
                .build();
    }

    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorDto handleBusinessException(final BusinessException e) {

        ErrorCode errorCode = e.getStaticErrorCode();

        log.error(e.getMessage());
        log.error(ExceptionUtils.getStackTrace(e));

        return ErrorDto.builder()
                .errorCode(errorCode.getCode())
                .errorMsg(errorCode.getMessage())
                .errorDetail(ExceptionUtils.getStackTrace(e))
                .build();

    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorDto handleException(Exception e) {

        log.error(e.getMessage());
        log.error(ExceptionUtils.getStackTrace(e));

        return ErrorDto.builder()
                .errorCode(ErrorCode.SYSTEM_ERROR.getCode())
                .errorMsg(ErrorCode.SYSTEM_ERROR.getMessage())
                .errorDetail(ExceptionUtils.getStackTrace(e))
                .build();

    }

}
