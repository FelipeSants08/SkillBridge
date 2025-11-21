package santana.dev.skillbridge.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import santana.dev.skillbridge.domain.dto.JWTUserData;
import santana.dev.skillbridge.domain.dto.request.UserExperienceRequest;
import santana.dev.skillbridge.domain.dto.request.UserSkillRequest;
import santana.dev.skillbridge.domain.dto.response.UserResponse;
import santana.dev.skillbridge.domain.model.User;
import santana.dev.skillbridge.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    public final UserService service;

    @PutMapping("/experience")
    public ResponseEntity<Void> updateExpecienceUser(@RequestBody UserExperienceRequest request,
                                                     @AuthenticationPrincipal JWTUserData principal) {
        service.updateUserExperience(principal.userId(), request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/skils")
    public ResponseEntity<Void> addSkillUser(@RequestBody UserSkillRequest request,
                                             @AuthenticationPrincipal JWTUserData principal) {
        service.addUserSkill(principal.userId(), request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/my-user")
    public ResponseEntity<UserResponse> findUser(@AuthenticationPrincipal JWTUserData principal) {
        return ResponseEntity.ok(service.findUser(principal.userId()));
    }
}
