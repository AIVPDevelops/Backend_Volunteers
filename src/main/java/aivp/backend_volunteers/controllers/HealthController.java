package aivp.backend_volunteers.controllers;

import aivp.backend_volunteers.models.HttpResponse;
import aivp.backend_volunteers.utils.Constants;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
@AllArgsConstructor
public class HealthController {

    @GetMapping()
    public ResponseEntity<HttpResponse<String>> health() {
        return ResponseEntity.ok(new HttpResponse<>(Constants.STATUS_OK,Constants.BACKEND_STATUS_OK, Constants.MESSAGE_OK));
    }
}




