package com.velb.SecondMs.services;

import com.velb.SecondMs.controllers.dto.SaveFirstEntityRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class FirstMsCallServiceImpl implements FirstMsCallService {

    @Autowired
    private final RestTemplate restTemplate;

    @Value("${cluster.firstms.host}")
    private String FIRST_MS_NAME;

    @Value("${cluster.firstms.port}")
    private String FIRST_MS_PORT;

    @Value("${cluster.firstms.url}")
    private String FIRST_MS_URL;

    @Override
    public Long saveInFirstTable(SaveFirstEntityRequest request) {
        return restTemplate.postForEntity(createFirstMsBaseUrl() + "/entities", request, Long.class).getBody();
    }

    private String createFirstMsBaseUrl() {
        return "http://" + FIRST_MS_NAME + ":" + FIRST_MS_PORT + FIRST_MS_URL;
    }
}
