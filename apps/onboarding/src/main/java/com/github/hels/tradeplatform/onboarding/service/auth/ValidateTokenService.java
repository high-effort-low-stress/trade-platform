package com.github.hels.tradeplatform.onboarding.service.auth;

import com.github.hels.tradeplatform.onboarding.http.security.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ValidateTokenService {
    private final JwtTokenUtil jwtTokenUtil;

    public void execute(String token){
        jwtTokenUtil.verifyToken(token);
    }
}
