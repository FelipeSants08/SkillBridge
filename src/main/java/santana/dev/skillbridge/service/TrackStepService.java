package santana.dev.skillbridge.service;

import jakarta.persistence.Enumerated;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import santana.dev.skillbridge.domain.dto.request.StatusTrackRequest;
import santana.dev.skillbridge.domain.dto.response.TrackStepResponse;
import santana.dev.skillbridge.domain.model.StatusTrack;
import santana.dev.skillbridge.domain.model.TrackStep;
import santana.dev.skillbridge.domain.model.User;
import santana.dev.skillbridge.repository.TrackStepRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrackStepService {

    private final TrackStepRepository trackStepRepository;

    public void trocarStatusTrack(Long id, StatusTrackRequest statusTrackRequest) {

    }



}
