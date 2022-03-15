package com.microservice.tutorial.microservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountRegistration {

    private String firstName;
    private String lastName;
    private String dob;
    private int ssn;
    private String email;
    private int mobileNumber;
    private String homeAddress;
    private String mailAddress;
    private String accountType;
    private double minBalance;

}
