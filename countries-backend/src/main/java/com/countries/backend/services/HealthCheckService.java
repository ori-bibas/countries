package com.countries.backend.services;

import com.countries.backend.helpers.HealthConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class HealthCheckService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public HealthCheckService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Map<String, Object> performHealthCheck() {
        Map<String, Object> healthCheckResponse = new HashMap<>();
        healthCheckResponse.put(HealthConstants.API.getKey(), HealthConstants.OK.getKey());
        performPersistenceTest(healthCheckResponse);
        return healthCheckResponse;
    }

    public void performPersistenceTest(Map<String, Object> healthCheckResponse) {
        try {
            jdbcTemplate.queryForObject("SELECT 1", Integer.class);
            healthCheckResponse.put(HealthConstants.PERSISTENCE.getKey(), HealthConstants.OK.getKey());
        } catch (Exception e) {
            Map<String, Object> persistenceError = new HashMap<>();
            persistenceError.put(HealthConstants.ERROR.getKey(), e.getMessage());
            healthCheckResponse.put(HealthConstants.PERSISTENCE.getKey(), persistenceError);
        }
    }

}
