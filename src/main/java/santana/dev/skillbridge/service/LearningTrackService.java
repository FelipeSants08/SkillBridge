package santana.dev.skillbridge.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import santana.dev.skillbridge.domain.dto.request.StatusTrackRequest;
import santana.dev.skillbridge.domain.dto.response.LearningTrackResponse;
import santana.dev.skillbridge.domain.dto.response.TrackStepResponse;
import santana.dev.skillbridge.domain.model.LearningTrack;
import santana.dev.skillbridge.domain.model.TrackStep;
import santana.dev.skillbridge.domain.model.User;
import santana.dev.skillbridge.repository.LearningTrackRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LearningTrackService {

    private final LearningTrackRepository learningTrackRepository;

    @Transactional
    public List<LearningTrackResponse> findAllUser(User user){
        var tracks = learningTrackRepository.findAll().stream().filter(l -> l.getUser().getId() == user.getId()).toList();
        return tracks.stream()
                .map(this::convertToResponse)
                .toList();
    }


    public void alterStatus(Long id, StatusTrackRequest request){

    }

    @Transactional
    public LearningTrack convertLearningTrack(LearningTrackResponse response, User user) {
        learningTrackRepository.deleteByUser(user);
        LearningTrack track = new LearningTrack();
        track.setTargetJobGoal(response.targetJobGoal());
        List<TrackStep> steps = response.trackSteps().stream().map(stepDto ->{
            TrackStep step = new TrackStep();
            step.setTitle(stepDto.title());
            step.setEstimatedTime(stepDto.estimatedTime());
            step.setDescription(stepDto.description());
            step.setLinks(stepDto.links());
            step.setResources(stepDto.resources());
            step.setStatus(stepDto.status());
            step.setLearningTrack(track);
            return step;
        }).toList();
        track.setUser(user);
        track.setTrackSteps(steps);
        return learningTrackRepository.save(track);
    }

    public LearningTrackResponse convertToResponse(LearningTrack track) {
        List<TrackStepResponse> stepResponses = track.getTrackSteps().stream()
                .map(step -> new TrackStepResponse(
                        step.getTitle(),
                        step.getDescription(),
                        step.getEstimatedTime(),
                        step.getLinks(),
                        step.getResources(),
                        step.getStatus()
                ))
                .toList();
        return new LearningTrackResponse(
                track.getUser().getId(),
                track.getTargetJobGoal(),
                stepResponses
        );
    }

    public void deleteLearningTrack(User user){
        learningTrackRepository.deleteByUser(user);
    }


}
