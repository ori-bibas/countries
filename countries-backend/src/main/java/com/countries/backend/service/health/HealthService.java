package com.countries.backend.service.health;

import com.countries.backend.helper.HealthConstants;
import com.countries.backend.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class HealthService {

    private final CountryRepository countryRepository;

    public HealthService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public Map<String, Object> performHealthCheck() {
        Map<String, Object> healthCheckResponse = new HashMap<>();
        healthCheckResponse.put(HealthConstants.API.getKey(), HealthConstants.OK.getKey());
        performPersistenceTest(healthCheckResponse);
        return healthCheckResponse;
    }

    public void performPersistenceTest(Map<String, Object> healthCheckResponse) {
        try {
            countryRepository.count();
            healthCheckResponse.put(HealthConstants.PERSISTENCE.getKey(), HealthConstants.OK.getKey());
        } catch (Exception e) {
            Map<String, Object> persistenceError = new HashMap<>();
            persistenceError.put(HealthConstants.ERROR.getKey(), e.getMessage());
            healthCheckResponse.put(HealthConstants.PERSISTENCE.getKey(), persistenceError);
        }
    }

}
