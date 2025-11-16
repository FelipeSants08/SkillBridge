package santana.dev.skillbridge.domain.dto.request;

import java.util.List;

public record UserSkillsUpdateRequest(List<UserSkillDetails> userSkills) {
}
