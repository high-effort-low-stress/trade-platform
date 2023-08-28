package com.github.hels.tradeplatform.onboarding.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.github.hels.tradeplatform.onboarding.dto.domain.UserDto;
import com.github.hels.tradeplatform.onboarding.exceptions.ApiException;
import com.github.hels.tradeplatform.onboarding.exceptions.UnauthorizedException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;

@Component
@RequiredArgsConstructor
public class JwtTokenUtil implements Serializable {

    public String getUsernameFromToken(String token) {
        return decode(token).getSubject();
    }

    public LocalDateTime getExpirationDateFromToken(String token) {
        return LocalDateTime.ofInstant(decode(token).getExpiresAtAsInstant(), ZoneOffset.UTC);
    }

    private Boolean isTokenExpired(String token) {
        return decode(token).getExpiresAtAsInstant().isBefore(LocalDateTime.now().toInstant(ZoneOffset.UTC));
    }

    private DecodedJWT decode(String token) {
        return JWT.decode(token);
    }

    public String generateToken(UserDto userDetails) {
        return doGenerateToken(userDetails);
    }

    private String doGenerateToken(UserDto user) {
        Algorithm algorithm = Algorithm.HMAC256("secret");
        return JWT.create()
                .withIssuer("trade-platform")
                .withClaim("phone_number", user.getPhoneNumber())
                .withClaim("email", user.getEmail())
                .withClaim("name", user.getName())
                .withIssuedAt(LocalDateTime.now().toInstant(ZoneOffset.UTC))
                .withExpiresAt(LocalDateTime.now().toInstant(ZoneOffset.UTC).plus(1, ChronoUnit.HOURS))
                .withSubject(user.getEmail())
                .sign(algorithm);
    }

    public void verifyToken(String bearer){
        try{
            String token = bearer.split(" ")[1];
            JWT.require(Algorithm.HMAC256("secret"))
                    .withIssuer("trade-platform")
                    .build()
                    .verify(token);
        }
        catch(JWTVerificationException ex){
            throw new UnauthorizedException("Token inválido");
        } catch(Exception ex){
            throw new RuntimeException("Erro ao verificar token");
        }

    }

}
