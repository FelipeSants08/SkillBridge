package santana.dev.skillbridge.domain.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record RegisterUserRequest (@NotEmpty(message = "Nome é obrigatório")
                                   String nome,
                                   @NotEmpty(message = "Email obrigatório")
                                   @Email
                                   String email,
                                   @NotEmpty(message = "Senha é obrigatória")
                                   String password){
}
