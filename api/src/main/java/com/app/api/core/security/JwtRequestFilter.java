package com.app.api.core.security;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.api.core.auth.JwtTokenUtil;
import com.app.api.core.auth.JwtUserDetailsService;
import com.app.api.core.error.exception.BusinessException;
import com.app.api.core.error.exception.ErrorCode;
import com.app.api.domain.role.Role;
import com.app.api.domain.role.support.RoleSupport;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import io.jsonwebtoken.ExpiredJwtException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.app.api.utils.ApiDomainUtils.notStartWith;

@Slf4j
@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    private JwtUserDetailsService jwtUserDetailsService;
    private JwtTokenUtil jwtTokenUtil;
    private RoleSupport roleSupport;

    public JwtRequestFilter(JwtUserDetailsService jwtUserDetailsService,
                            JwtTokenUtil jwtTokenUtil,
                            RoleSupport roleSupport) {
        this.jwtUserDetailsService = jwtUserDetailsService;
        this.jwtTokenUtil = jwtTokenUtil;
        this.roleSupport = roleSupport;
    }

    @Override
    protected void doFilterInternal( HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {

        log.info("======== {} ========", "JwtRequestFilter");

        final String requestTokenHeader = request.getHeader("Authorization");

        final String url = request.getRequestURI();

        log.info("======== URL :: {} ========", url);

        String username = null;
        String jwtToken = null;

        if (notStartWith(url, "/login") && notStartWith(url, "/sign")) {

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
                throw new BusinessException(ErrorCode.AUTHORIZATION_NOT_FOUND);
            }

            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

                /**
                 * User Info Search
                 *
                 * ======================
                 */
                UserDetails userDetails = this.jwtUserDetailsService.loadUserByUsername(username);

                if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {

                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                            new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                    usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

                }

            } else {

                /**
                 * Jwt not init subject
                 *
                 * ==============================
                 */
                throw new BusinessException(ErrorCode.USERNAME_NOT_FOUND);
            }

            if (notStartWith(url, "/menu")) {

                List<Role> roles = jwtUserDetailsService.loadUserRoles(username);

                log.info("======== Auth Roles {} ========", roles);

                List<String> roleTitle = roles.stream().map(m -> m.getTitle()).collect(Collectors.toList());

                List<Role> role = roleSupport.findByTitles(roleTitle);

                List<String> auths = new ArrayList<>();

                role.stream().map(Role::getMenus).forEach(f -> auths.addAll(f.stream().map(v -> v.getAuthUrl()).collect(Collectors.toList())));

                if (auths.stream()
                        .map(f -> f.equals(url))
                        .distinct()
                        .anyMatch(f -> f.equals(Boolean.TRUE))) {

                    throw new BusinessException(ErrorCode.AUTH_NOT_ROLES);

                }

            }

        }

        chain.doFilter(request, response);
    }

}
