package santana.dev.skillbridge.config;

import lombok.Builder;

@Builder
public record JWTUserData(Long userId, String email) {
}
