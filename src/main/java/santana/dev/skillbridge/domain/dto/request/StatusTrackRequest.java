package santana.dev.skillbridge.domain.dto.request;

import jakarta.persistence.Enumerated;
import santana.dev.skillbridge.domain.model.StatusTrack;

public record StatusTrackRequest(@Enumerated StatusTrack statusTrack) {
}
