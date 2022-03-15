package com.microservice.tutorial.microservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountNumber {
    private int accountNum;

    public AccountNumber(int accountNum) {
        this.accountNum = accountNum;
    }
}
