package com.reference.backendreference.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserResponse {

    private String id;
    private String firstName;
    private String lastName;
    private String emailId;
    private Long phoneNumber;
}
