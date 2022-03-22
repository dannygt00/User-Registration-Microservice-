package com.microservice.tutorial.microservice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import com.microservice.tutorial.microservice.controller.AccountRegistrationController;
import com.microservice.tutorial.microservice.dto.Account;
import com.microservice.tutorial.microservice.repository.AccountCrudRepository;
import com.microservice.tutorial.microservice.service.AccountService;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@EnableAutoConfiguration
@SpringBootTest
class MicroserviceApplicationTests {

	@Mock
	private AccountRegistrationController controller;

	@Mock
	private AccountService accountService;

	@Mock
	AccountCrudRepository accountCrudRepository;

	@Test
	void contextLoads() {
		assertNotEquals(controller, null);
	}

	@Test
	void testRepoSave() {
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
		accountService.addAccount(account);
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
		accountService.addAccount(account2);

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
		accountService.addAccount(account3);

		assertEquals(3, accountService.getAccounts().size());
	}
}
