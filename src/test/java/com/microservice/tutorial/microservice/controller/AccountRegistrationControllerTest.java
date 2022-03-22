package com.microservice.tutorial.microservice.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.microservice.tutorial.microservice.dto.Account;
import com.microservice.tutorial.microservice.repository.AccountCrudRepository;
import com.microservice.tutorial.microservice.service.AccountService;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(AccountRegistrationController.class)
@SpringBootTest
public class AccountRegistrationControllerTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private AccountRegistrationController accountRegistrationController;

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountCrudRepository accountCrudRepository;

    @Test
    void testDeleteAccount() {
        Account account = new Account();
        account.setAccountNum(1);
        account.setFirstName("Daniel");
        account.setLastName("Ram");
        account.setSsn(105223434);
        account.setEmail("email@email.com");
        account.setMobileNumber(561786250);
        account.setHomeAddress("6663 old farm trail");
        account.setMailAddress("6663 old farm trail");
        account.setAccountType("Savings");
        account.setMinBalance(5);
        accountRegistrationController.processRegistration(account);

        assertEquals(accountService.getAccounts().size(), 3);

    }

    @Test
    void testGetAccounts() {

    }

    @Test
    void testProcessRegistration() {

    }

    @Test
    void testUpdateAccount() {

    }
}
