package santana.dev.skillbridge.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;
import santana.dev.skillbridge.domain.model.User;

import java.time.Instant;
import java.util.Optional;

@Component
public class TokenConfig {

    private String secret = "secret";


    public String generateToken(User user){

        Algorithm algorithm = Algorithm.HMAC256(secret);
        return JWT.create()
                .withClaim("UserId", user.getId())
                .withSubject(user.getEmail())
                .withExpiresAt(Instant.now().plusSeconds(90000))
                .withIssuedAt(Instant.now())
                .sign(algorithm);
    }

    public Optional<JWTUserData> validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);

            DecodedJWT decoded = JWT.require(algorithm)
                    .build().verify(token);

            return Optional.of(JWTUserData.builder()
                    .userId(decoded.getClaim("UserId").asLong())
                    .email(decoded.getSubject())
                    .build());
        } catch (JWTVerificationException ex){
            return Optional.empty();
        }

    }

}
