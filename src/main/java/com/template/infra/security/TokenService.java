package com.template.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.template.common.Messages;
import com.template.common.exceptions.BusinessException;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Service
@Data
public class TokenService {

    @Value("${token.secret}")
    private String secret;

    @Value("${token.issuer}")
    private String issuer;

    @Value("${token.expiration-in-days}")
    private int tokenExpirationInDays;

    public String generateToken(String email) {
        try {
            var algorithm = getAlgorithm();

            return JWT.create()
                    .withIssuer(issuer)
                    .withSubject(email)
                    .withExpiresAt(generateExpirationDate())
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new BusinessException(Messages.ERROR_AUTHENTICATING_USER.getMessage());
        }
    }

    public String validateToken(String token) {
        try {
            var algorithm = getAlgorithm();

            return JWT.require(algorithm)
                    .withIssuer(issuer)
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException exception) {
            throw new BusinessException(Messages.USER_INVALID_TOKEN.getMessage());
        }
    }

    private Algorithm getAlgorithm() {
        return Algorithm.HMAC256(secret);
    }

    private Instant generateExpirationDate() {
        return ZonedDateTime.now(ZoneId.of("America/Sao_Paulo")).plusDays(tokenExpirationInDays).toInstant();
    }

}
