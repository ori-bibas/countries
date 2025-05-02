package com.countries.backend.controller;

import com.countries.backend.service.HealthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/health")
public class HealthController {

    private final HealthService healthService;

    public HealthController(HealthService healthService) {
        this.healthService = healthService;
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> healthCheck() {
        Map<String, Object> healthCheckResponse = healthService.performHealthCheck();
        boolean hasErrors = healthCheckResponse.values().stream().anyMatch(val -> val instanceof Map);
        HttpStatus status = hasErrors ? HttpStatus.SERVICE_UNAVAILABLE : HttpStatus.OK;
        return new ResponseEntity<>(healthCheckResponse, status);
    }

}
