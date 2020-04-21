package com.app.api.core.auth;

public interface JwtUtils {

   String createToken();

   void verifyToken(String giveToken);

}
