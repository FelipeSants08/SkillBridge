package santana.dev.skillbridge.domain.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserExperienceRequest(@NotBlank(message = "Campo obrigatório")
                                    @Size(min = 4, max = 25, message = "Minimo de caracteres é 4, e máximo de 25")
                                    String jobGoal,
                                    @NotBlank
                                    @Size(min = 5, message = "Minimo de 5 caracteres")
                                    String experienceSummary) {
}
