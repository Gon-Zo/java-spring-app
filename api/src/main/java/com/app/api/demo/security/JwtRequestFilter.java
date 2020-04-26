package com.app.api.demo.security;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.app.api.demo.auth.JwtTokenUtil;
import com.app.api.demo.auth.JwtUserDetailsService;
import com.app.api.enums.Roles;
import com.app.api.global.error.exception.BusinessException;
import com.app.api.global.error.exception.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import io.jsonwebtoken.ExpiredJwtException;
import java.io.IOException;

@Slf4j
@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    private JwtUserDetailsService jwtUserDetailsService;
    private JwtTokenUtil jwtTokenUtil;

    public JwtRequestFilter(JwtUserDetailsService jwtUserDetailsService, JwtTokenUtil jwtTokenUtil) {
        this.jwtUserDetailsService = jwtUserDetailsService;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        log.info("======== {} ========", "JwtRequestFilter");

        final String requestTokenHeader = request.getHeader("Authorization");

        String username = null;
        String jwtToken = null;

        if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
            jwtToken = requestTokenHeader.substring(7);

            try {
                username = jwtTokenUtil.getUsernameFromToken(jwtToken);
                log.info("======== Auth User Name :: {} ========", username);
            } catch (IllegalArgumentException e) {
                throw new BusinessException(ErrorCode.UNABLE_JWT_TOKEN);
            } catch (ExpiredJwtException e) {
                throw new BusinessException(ErrorCode.EXPIRED_JWT_TOKEN);
            }

        } else {

//            throw new BusinessException(ErrorCode.AUTHORIZATION_NOT_FOUND);
            log.info("JWT Authorization Not Found");

        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = this.jwtUserDetailsService.loadUserByUsername(username);

            if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {

                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

            }

        }else{
            /**
             * Jwt Not init subject
             * ==============================
             */

            log.info("user Name not found");

//            throw new BusinessException(ErrorCode.USERNAME_NOT_FOUND);
        }

//        String roles = jwtUserDetailsService.loadUserRoles(username);

        log.info("======== {} ========", "RolesFilter");
//        log.info("======== Roles {} ========", roles);

        final String url = request.getRequestURI();
        log.info("======== URL {} ========", url);

//        if (url.startsWith("/hello") && !StringUtils.equals(roles, Roles.U.getValue())) {
//            throw new BusinessException(ErrorCode.ROLE_NOT_USER);
//        }

        chain.doFilter(request, response);

    }

}
