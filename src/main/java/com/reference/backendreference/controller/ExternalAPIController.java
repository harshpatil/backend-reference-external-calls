package com.reference.backendreference.controller;

import com.reference.backendreference.model.CreateUserRequest;
import com.reference.backendreference.service.ExternalAPIService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/external")
public class ExternalAPIController {

    @Autowired
    ExternalAPIService externalAPIService;

    @ApiOperation(value = "Sample GET")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> sampleGet(@RequestParam("ipAddress") String ipAddress){
        return externalAPIService.sampleGetCall(ipAddress);
    }

    @ApiOperation(value = "test Post", notes = "test Post")
    @RequestMapping(path="testPost", method = RequestMethod.GET)
    public ResponseEntity<Object> testPost(@RequestBody CreateUserRequest createUserRequest){
        return externalAPIService.createUser(createUserRequest);
    }

    @ApiOperation(value = "test Post with header", notes = "test post woth header")
    @RequestMapping(path="testPostWithHeaders", method = RequestMethod.GET)
    public ResponseEntity<Object> testPostWithHeaders(@RequestBody CreateUserRequest createUserRequest){
        return externalAPIService.createUserUsingHeader(createUserRequest);
    }
}
