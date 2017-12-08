package com.reference.backendreference.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class IPApiResponse {

    private String ip;
    private String city;
    private String country;
    private String countryCode;
    private String region;
    private String regionName;
    private String zip;
}
