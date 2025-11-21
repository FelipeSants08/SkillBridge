package santana.dev.skillbridge.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import santana.dev.skillbridge.domain.dto.JWTUserData;
import santana.dev.skillbridge.domain.dto.response.LearningTrackResponse;
import santana.dev.skillbridge.domain.model.LearningTrack;
import santana.dev.skillbridge.domain.model.User;
import santana.dev.skillbridge.repository.LearningTrackRepository;
import santana.dev.skillbridge.service.ChatService;
import santana.dev.skillbridge.service.LearningTrackService;
import santana.dev.skillbridge.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/ia")
@RequiredArgsConstructor
public class DashboardController {

    private final ChatService chatService;
    private final UserService userService;
    private final LearningTrackService trackService;

    @GetMapping
    public String ola(){
        return "ola Projeto";
    }

    @PostMapping
    public ResponseEntity<LearningTrackResponse> generated(@AuthenticationPrincipal JWTUserData principal){
        User user = userService.findUserById(principal.userId());
        LearningTrackResponse track = chatService.sendMessage(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(track);
    }

    @GetMapping("/learning")
    public ResponseEntity<List<LearningTrackResponse>> findAllUser(@AuthenticationPrincipal JWTUserData principal){
        User user = userService.findUserById(principal.userId());
        return ResponseEntity.ok(trackService.findAllUser(user));
    }

}
