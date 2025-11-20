package santana.dev.skillbridge.domain.dto.response;

import santana.dev.skillbridge.domain.model.TrackStep;

import java.util.List;

public record LearningTrackResponse(Long userId,
                                    String targetJobGoal,
                                    List<TrackStepResponse> trackSteps) {
}
