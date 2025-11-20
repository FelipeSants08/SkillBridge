package santana.dev.skillbridge.domain.dto.response;

import santana.dev.skillbridge.domain.model.StatusTrack;

import java.util.List;

public record TrackStepResponse(String title,
                                String estimatedTime,
                                String description,
                                List<String> links,
                                List<String> resources,
                                StatusTrack status) {
}
