package com.microservice.tutorial.microservice.repository;

import com.microservice.tutorial.microservice.dto.Account;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@EnableAutoConfiguration
public class UserRepoTest {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    AccountCrudRepository accountCrudRepository;

    @Test
    void testDeleteAccountbyId() {
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
        entityManager.persist(account);
        Account account2 = new Account();

        account2.setAccountNum(2);
        account2.setFirstName("Test2");
        account2.setLastName("Ram2");
        account2.setSsn(1052233);
        account2.setEmail("email2@email.com");
        account2.setMobileNumber(561786252);
        account2.setHomeAddress("6663 old farm trail test");
        account2.setMailAddress("6663 old farm trail test");
        account2.setAccountType("Savings");
        account2.setMinBalance(10);
        entityManager.persist(account2);

        Account account3 = new Account();
        account3.setAccountNum(3);
        account3.setFirstName("Test3");
        account3.setLastName("Ram3");
        account3.setSsn(1052233);
        account3.setEmail("email3@email.com");
        account3.setMobileNumber(561786252);
        account3.setHomeAddress("6663 old farm trail test");
        account3.setMailAddress("6663 old farm trail test");
        account3.setAccountType("Savings");
        account3.setMinBalance(10);
        entityManager.persist(account3);

        Iterable<Account> accounts = accountCrudRepository.findAll();

    }
}
