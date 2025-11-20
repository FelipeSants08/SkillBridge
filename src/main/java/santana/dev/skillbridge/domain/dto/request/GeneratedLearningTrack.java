package santana.dev.skillbridge.domain.dto.request;

import santana.dev.skillbridge.domain.dto.response.TrackStepResponse;
import santana.dev.skillbridge.domain.model.TrackStep;

import java.util.List;

public record GeneratedLearningTrack(String targetJobGoal,
                                     List<TrackStepResponse> trackSteps) {
}
