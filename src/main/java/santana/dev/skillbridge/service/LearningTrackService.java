package santana.dev.skillbridge.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import santana.dev.skillbridge.domain.dto.response.LearningTrackResponse;
import santana.dev.skillbridge.domain.model.LearningTrack;
import santana.dev.skillbridge.domain.model.TrackStep;
import santana.dev.skillbridge.domain.model.User;
import santana.dev.skillbridge.repository.LearningTrackRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LearningTrackService {

    private final LearningTrackRepository learningTrackRepository;


    public LearningTrack convertLearningTrack(LearningTrackResponse response, User user) {
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

}
