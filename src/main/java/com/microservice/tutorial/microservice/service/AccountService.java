package com.microservice.tutorial.microservice.service;

import java.util.ArrayList;
import java.util.List;

import com.microservice.tutorial.microservice.dto.Account;
import com.microservice.tutorial.microservice.repository.AccountCrudRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private final AccountCrudRepository accountCrudRepository;

    @Autowired
    public AccountService(AccountCrudRepository accountCrudRepository) {
        this.accountCrudRepository = accountCrudRepository;
    }

    public void addAccount(Account account) {
        accountCrudRepository.save(account);
    }

    public Account getAccount(int id) {
        try {
            Account foundAcc = accountCrudRepository.findByAccountNum(id);
            return foundAcc;
        } catch (Exception e) {
            System.out.println("Account with given ID does not exist");
            return null;
        }
    }

    public List<Account> getAccounts() {
        List<Account> accountList = new ArrayList<Account>();
        accountList = (List<Account>) accountCrudRepository.findAll();
        return accountList;
    }

    public boolean deleteAccount(int id) {
        try {
            Account foundAcc = accountCrudRepository.findByAccountNum(id);
            accountCrudRepository.delete(foundAcc);
            return true;
        } catch (Exception e) {
            System.out.println("Account with given ID does not exist");
            return false;
        }
    }
}
