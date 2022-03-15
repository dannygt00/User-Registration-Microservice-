package com.microservice.tutorial.microservice.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountNum;

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
