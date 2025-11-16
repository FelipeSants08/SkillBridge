package santana.dev.skillbridge.domain.dto;

import lombok.Builder;

@Builder
public record JWTUserData(Long userId, String email) {
}
