package com.reference.backendreference.service;

import com.reference.backendreference.model.CreateUserRequest;
import com.reference.backendreference.model.CreateUserResponse;
import com.reference.backendreference.model.IPApiResponse;
import com.reference.backendreference.util.ApiError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
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
            ipApiResponse.setIp(ipAddress);
            return new ResponseEntity<>(ipApiResponse, HttpStatus.OK);
        }catch (Exception e){
            log.error("Error in getting geo location {}", e);
            return new ResponseEntity<>(new ApiError("Error in getting geo location"), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Object> createUser(CreateUserRequest createUserRequest){
        try{
            CreateUserResponse createUserResponse = restTemplate.postForObject("http://localhost:8080/user", createUserRequest, CreateUserResponse.class);
            return new ResponseEntity<>(createUserResponse, HttpStatus.OK);
        }catch (Exception e){
            log.error("Error in creating user {}", e);
            return new ResponseEntity<>(new ApiError("Error in creating user"), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Object> createUserUsingHeader(CreateUserRequest createUserRequest){
        try{
            MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
            headers.add("Content-Type", "application/json");

            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            HttpEntity<CreateUserRequest> request = new HttpEntity<>(createUserRequest, headers);

            CreateUserResponse createUserResponse = restTemplate.postForObject("http://localhost:8080/user", request, CreateUserResponse.class);
            return new ResponseEntity<>(createUserResponse, HttpStatus.OK);
        }catch (Exception e){
            log.error("Error in creating user {}", e);
            return new ResponseEntity<>(new ApiError("Error in creating user"), HttpStatus.BAD_REQUEST);
        }
    }


}
