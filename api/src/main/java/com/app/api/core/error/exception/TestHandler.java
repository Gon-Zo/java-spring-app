package com.app.api.core.error.exception;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
public class TestHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorDto handleBusinessException(final BusinessException e) {

        ErrorCode errorCode = e.getStaticErrorCode();

        return ErrorDto.builder()
                .errorCode(errorCode.getCode())
                .errorMsg(errorCode.getMessage())
                .errorDetail(ExceptionUtils.getStackTrace(e))
                .build();

    }

}
