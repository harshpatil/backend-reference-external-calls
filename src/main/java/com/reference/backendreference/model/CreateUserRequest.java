package com.reference.backendreference.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateUserRequest {

    private String firstName;
    private String lastName;
    private String emailId;
    private Long phoneNumber;
    private String password;
}

