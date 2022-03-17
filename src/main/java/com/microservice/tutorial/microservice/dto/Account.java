package com.microservice.tutorial.microservice.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@Data
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountNum;

    private String firstName;
    private String lastName;
    private String dob;
    private int ssn;
    private String email;
    private long mobileNumber;
    private String homeAddress;
    private String mailAddress;
    private String accountType;
    private double minBalance;

    public Account() {

    }

    public Account(String firstName, String lastName, String dob, int ssn, String email, long mobileNumber,
            String homeAddress, String mailAddress, String accountType, double minBalance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.ssn = ssn;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.homeAddress = homeAddress;
        this.mailAddress = mailAddress;
        this.accountType = accountType;
        this.minBalance = minBalance;
    }

    public Account(int accountNum, String firstName, String lastName, String dob, int ssn, String email,
            long mobileNumber, String homeAddress, String mailAddress, String accountType, double minBalance) {
        this.accountNum = accountNum;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.ssn = ssn;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.homeAddress = homeAddress;
        this.mailAddress = mailAddress;
        this.accountType = accountType;
        this.minBalance = minBalance;
    }

}