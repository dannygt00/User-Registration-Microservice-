package com.microservice.tutorial.microservice.controller;

import java.util.List;

import com.microservice.tutorial.microservice.dto.Account;
import com.microservice.tutorial.microservice.dto.AccountRegistration;
import com.microservice.tutorial.microservice.repository.AccountCrudRepository;
import com.microservice.tutorial.microservice.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class AccountRegistrationController {

    @Autowired
    AccountService accountService;

    @Autowired
    AccountCrudRepository accountCrudRepository;

    @GetMapping("/registration_form")
    public String viewRegistrationPage(Model model) {
        log.info("In account registration form");
        model.addAttribute("account", new Account());
        return "registration_form";
    }

    @GetMapping("/")
    public String viewHomePage() {
        log.info("At home page");
        return "index";
    }

    @GetMapping(path = "/accounts")
    public String getAccounts(Model model) {
        log.info("Attempting to show all open accounts");
        List<Account> list = accountService.getAccounts();
        model.addAttribute("getAccounts", list);
        return "accounts";
    }

    @RequestMapping("/process_register")
    public String processRegistration(Account account) {
        log.info("Collecting data and registering account");
        accountService.addAccount(account);
        return "registration_success";
    }

    @RequestMapping(path = "/delete/{accountNum}")
    public String deleteAccount(@PathVariable("accountNum") int id) {
        log.info("In delete account endpoint");
        accountService.deleteAccount(id);
        return "registration_success";
    }

    @PutMapping(value = "/accounts/{accountNum}")
    public void updateAccount(@PathVariable(value = "accountNum") int accountNum,
            @RequestBody AccountRegistration accountInputForm, @RequestHeader String authorization) {
        log.info("In Update Account");
        Account updatedAccount = accountService.updateAccount(accountNum, accountInputForm);
    }
}
