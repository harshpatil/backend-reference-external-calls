package com.reference.backendreference.service;

import com.reference.backendreference.model.IPApiResponse;
import com.reference.backendreference.util.ApiError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExternalAPIService {

    private RestTemplate restTemplate;
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public ExternalAPIService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public ResponseEntity<Object> sampleGetCall(String ipAddress){
        try{
            IPApiResponse ipApiResponse = restTemplate.getForObject("http://ip-api.com/json/" + ipAddress, IPApiResponse.class);
            return new ResponseEntity<>(ipApiResponse, HttpStatus.OK);
        }catch (Exception e){
            log.error("Error in getting geo location {}", e);
            return new ResponseEntity<>(new ApiError("Error in getting geo location"), HttpStatus.BAD_REQUEST);
        }
    }
}
