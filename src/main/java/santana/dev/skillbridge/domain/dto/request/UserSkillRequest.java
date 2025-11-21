package santana.dev.skillbridge.domain.dto.request;

import jakarta.validation.constraints.NotBlank;

public record UserSkillRequest(@NotBlank(message = "Campo obrigatório") String skill) {
}
