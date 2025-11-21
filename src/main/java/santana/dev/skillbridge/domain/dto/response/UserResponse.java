package santana.dev.skillbridge.domain.dto.response;

import java.util.List;

public record UserResponse(Long userId, String name, String email, String jobGoal, String experienceSummary, List<LearningTrackResponse> learningTrackResponse) {
}
