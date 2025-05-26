package aivp.backend_volunteers.controllers;

import aivp.backend_volunteers.models.HttpResponse;
import aivp.backend_volunteers.models.auth.AuthRequestDto;
import aivp.backend_volunteers.models.auth.AuthResponseDto;
import aivp.backend_volunteers.models.signup.SignUpRequestDto;
import aivp.backend_volunteers.services.implementations.AuthServiceImpl;
import aivp.backend_volunteers.utils.Constants;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthServiceImpl authenticationService;

    @PostMapping("/login")
    public ResponseEntity<HttpResponse<AuthResponseDto>> login(@RequestBody AuthRequestDto request) {
        AuthResponseDto authResponse = authenticationService.authenticate(request);
        return ResponseEntity.ok(new HttpResponse<>(Constants.STATUS_OK, authResponse, Constants.MESSAGE_OK));
    }
    @PostMapping("/sign-up")
    public ResponseEntity<HttpResponse<String>> signUp(@RequestBody SignUpRequestDto request) {
        String authResponse = authenticationService.signUp(request);
        return ResponseEntity.ok(new HttpResponse<>(Constants.STATUS_OK, authResponse, Constants.MESSAGE_OK));
    }
}
