package com.app.api.global.error.exception;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {

    INVALID_INPUT_VALUE(400, "C001", " Invalid Input Value"),
    METHOD_NOT_ALLOWED(405, "C002", " Invalid Input Value"),
    ENTITY_NOT_FOUND(400, "C003", " Entity Not Found"),
    INTERNAL_SERVER_ERROR(500, "C004", "Server Error"),
    INVALID_TYPE_VALUE(400, "C005", " Invalid Type Value"),
    HANDLE_ACCESS_DENIED(403, "C006", "Access is Denied"),


    // Member
    EMAIL_DUPLICATION(400, "M001", "Email is Duplication"),
    LOGIN_INPUT_INVALID(400, "M002", "Login input is invalid"),

    // Coupon
    COUPON_ALREADY_USE(400, "CO001", "Coupon was already used"),
    COUPON_EXPIRE(400, "CO002", "Coupon was already expired"),


    // Uesr
    LOGIN_USER_NOT_FOUND(500, "U001", "Login User Not Found"),
    USER_EMAIL_FAIL(500, "U002", "Login User Email Fail"),
    USER_PASSWORD_FAIL(500, "U003", "Login User Password fail"),
    USER_UPDATE_FAIL(500, "U004", "User Update Fail"),
    USER_NOT_FOUND(500 , "U005" , "User is Not Found") ,

    USER_DISABLED(500 , "U006" , "USER DISABLED") ,
    INVALID_CREDENTIALS(500 , "U007" , "INVALID CREDENTIALS") ,

    // Store
    STORE_NOT_FOUND(500 , "S001" , "Store is Not Found"),

    // Category
    CATEGORY_NOT_FOUND(500 , "P001" , "Category is Not Found"),
    PRODUCT_NOT_FOUND(500 , "P002" , "Product is Not Found"),

    //jwt
    UNABLE_JWT_TOKEN(500 , "J001" , "Unable to get JWT Token"),
    EXPIRED_JWT_TOKEN(500 , "J002" , "JWT Token has expired"),
    AUTHORIZATION_NOT_FOUND(500, "J003", "JWT Authorization Not Found"),
    USERNAME_NOT_FOUND(500, "J004", "JWT UserName Not Found"),

    //roles
    ROLE_NOT_MANAGER(500, "R001", "Role Is Not Manager"),
    ROLE_NOT_USER(500, "R002", "Role Is Not User"),

    ;

    private final String code;
    private final String message;
    private int status;

    ErrorCode(final int status, final String code, final String message) {
        this.status = status;
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public String getCode() {
        return code;
    }

    public int getStatus() {
        return status;
    }


}