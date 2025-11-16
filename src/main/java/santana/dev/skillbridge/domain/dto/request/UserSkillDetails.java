package santana.dev.skillbridge.domain.dto.request;

import santana.dev.skillbridge.domain.model.Skill;

public record UserSkillDetails(SkillRequest skill, String skillLevel) {
}
