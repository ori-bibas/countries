package com.countries.backend.controllers;

import com.countries.backend.services.HealthCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/health")
public class HealthController {

    private final HealthCheckService healthCheckService;

    @Autowired
    public HealthController(HealthCheckService healthCheckService) {
        this.healthCheckService = healthCheckService;
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> healthCheck() {
        Map<String, Object> healthCheckResponse = healthCheckService.performHealthCheck();
        boolean hasErrors = healthCheckResponse.values().stream().anyMatch(val -> val instanceof Map);
        HttpStatus status = hasErrors ? HttpStatus.SERVICE_UNAVAILABLE : HttpStatus.OK;
        return new ResponseEntity<>(healthCheckResponse, status);
    }

}
