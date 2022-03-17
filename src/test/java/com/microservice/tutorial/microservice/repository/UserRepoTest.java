package com.microservice.tutorial.microservice.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.microservice.tutorial.microservice.dto.Account;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@EnableAutoConfiguration
public class UserRepoTest {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    AccountCrudRepository accountCrudRepository;

    @Test
    void testCreateAccount() {
        Account account = new Account();
        account.setFirstName("Daniel");
        account.setLastName("Ram");
        account.setSsn(105223434);
        account.setEmail("email@email.com");
        account.setMobileNumber(561786250);
        account.setHomeAddress("6663 old farm trail");
        account.setMailAddress("6663 old farm trail");
        account.setAccountType("Savings");
        account.setMinBalance(5);

        accountCrudRepository.save(account);

        Account savedUser = account;

        Account existUser = entityManager.find(Account.class, savedUser.getAccountNum());

        assertEquals(account, existUser);
    }
}
