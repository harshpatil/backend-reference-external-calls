package com.reference.backendreference.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
public class IPApiResponse {

    private String city;
    private String country;
    private String countryCode;
    private String region;
    private String regionName;
    private String zip;
}
