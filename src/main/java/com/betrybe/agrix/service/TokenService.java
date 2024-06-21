package com.betrybe.agrix.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Service for generate jwt.
 */
@Service
public class TokenService {

  @Value("${api.security.token.secret}")
  private String secret;

  /**
   * Methord for generate token.
   */
  public String generateToken(String username) {
    Algorithm algorithm = Algorithm.HMAC256(secret);

    return JWT.create()
        .withSubject(username)
        .withExpiresAt(generateExpirationDate())
        .sign(algorithm);
  }

  private Instant generateExpirationDate() {
    return Instant.now()
        .plus(2, ChronoUnit.HOURS);
  }

  /**
   * Methord for validate Token.
   */
  public String validateToken(String token) {
    Algorithm algorithm = Algorithm.HMAC256(secret);

    return JWT.require(algorithm)
        .build()
        .verify(token)
        .getSubject();
  }
}
