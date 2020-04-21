package com.app.api.core.auth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtilsImpl implements JwtUtils{

    private String TEST_SIGN_KEY = "TESTKEY";

    private Date EXPIRED_TIME = new Date(System.currentTimeMillis());

    private String ISSUER = "JJY";

    @Override
    public String createToken() {
        return JWT.create()
                .withIssuer(ISSUER)
                .withExpiresAt(EXPIRED_TIME)
                .sign(Algorithm.HMAC256(TEST_SIGN_KEY));
    }

    @Override
    public void verifyToken(String giveToken) {
        JWTVerifier jwtVerifier
                = JWT.require(Algorithm.HMAC256(TEST_SIGN_KEY))
                .withIssuer(ISSUER)
                .build();

        jwtVerifier.verify(giveToken);
    }

}
