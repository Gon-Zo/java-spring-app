package com.app.api.core.auth;

import com.app.api.domain.user.User;
import com.app.api.domain.user.UserRepository;
import com.app.api.global.error.exception.BusinessException;
import com.app.api.global.error.exception.ErrorCode;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JwtAuthInterceptor implements HandlerInterceptor {

    private JwtUtils jwtUtils;

    private UserRepository userRepository;

    private String HEADER_TOKEN_KEY = "token";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        User user = userRepository
                .findById(Long.parseLong(request.getHeader("userId")))
                .orElseThrow(() -> new BusinessException(ErrorCode.LOGIN_USER_NOT_FOUND));

        String givenToken = request.getHeader(HEADER_TOKEN_KEY);

        verifyToken(givenToken, user.getToken);

        return true;
    }

    private void verifyToken(String givenToken , String membersToken) throws IllegalAccessException {
        if(!givenToken.equals(membersToken)){
            throw  new IllegalAccessException("user token FALLLLL ~~~~~~~");
        }
        jwtUtils.verifyToken(givenToken);
    }



}
