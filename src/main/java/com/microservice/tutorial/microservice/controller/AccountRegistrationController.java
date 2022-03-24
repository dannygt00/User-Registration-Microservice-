package com.microservice.tutorial.microservice.controller;

import java.util.List;

import com.microservice.tutorial.microservice.dto.Account;
import com.microservice.tutorial.microservice.repository.AccountCrudRepository;
import com.microservice.tutorial.microservice.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class AccountRegistrationController {

    @Autowired
    AccountService accountService;

    @Autowired
    AccountCrudRepository accountCrudRepository;

    // Retrieves registration form
    @GetMapping("/registration_form")
    public String viewRegistrationPage(Model model) {
        log.info("In account registration form");
        model.addAttribute("account", new Account());
        return "registration_form";
    }

    // Displays home page
    @GetMapping("/index")
    public String viewHomePage() {
        log.info("At home page");
        return "index";
    }

    // Returns page with list of all Accounts currently registered
    @GetMapping(path = "/accounts")
    public String getAccounts(Model model) {
        log.info("Attempting to show all open accounts");
        List<Account> list = accountService.getAccounts();
        model.addAttribute("getAccounts", list);
        return "accounts";
    }

    // Collects data from registration form and inserts it into database
    @RequestMapping("/process_register")
    public String processRegistration(Account account) {
        log.info("Collecting data and registering account");

        switch (account.getAccountType()) {
            case "savings":
                account.setMinBalance(200);
                break;
            case "checkings":
                account.setMinBalance(300);
                break;
            case "cd":
                account.setMinBalance(2000);
                break;
            default:
                account.setMinBalance(0);
        }

        accountService.addAccount(account);
        return "registration_success";
    }

    // Deletes account using path variable
    @RequestMapping(path = "/delete/{accountNum}")
    public String deleteAccount(@PathVariable("accountNum") int id) {
        log.info("In delete account endpoint");
        accountService.deleteAccount(id);
        return "registration_success";
    }

}
