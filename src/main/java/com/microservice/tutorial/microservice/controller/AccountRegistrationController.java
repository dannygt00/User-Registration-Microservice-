package com.microservice.tutorial.microservice.controller;

import java.util.List;

import com.microservice.tutorial.microservice.dto.Account;
import com.microservice.tutorial.microservice.repository.AccountCrudRepository;
import com.microservice.tutorial.microservice.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AccountRegistrationController {

    @Autowired
    AccountService accountService;

    @Autowired
    AccountCrudRepository accountCrudRepository;

    @GetMapping("/registration_form")
    public String viewRegistrationPage(Model model) {
        model.addAttribute("account", new Account());
        return "registration_form";
    }

    @GetMapping("/")
    public String viewHomePage() {
        return "index";
    }

    @GetMapping(path = "/accounts")
    public String getAccounts(Model model) {
        List<Account> list = accountService.getAccounts();
        model.addAttribute("getAccounts", list);
        return "accounts";
    }

    @RequestMapping("/process_register")
    public String processRegistration(Account account) {
        accountService.addAccount(account);
        return "registration_success";
    }

    @RequestMapping(path = "/delete/{accountNum}")
    public String deleteAccount(@PathVariable("accountNum") int id) {
        accountService.deleteAccount(id);
        return "registration_success";
    }
}
