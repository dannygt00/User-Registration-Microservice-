package com.microservice.tutorial.microservice.service;

import java.util.ArrayList;
import java.util.List;

import com.microservice.tutorial.microservice.dto.Account;
import com.microservice.tutorial.microservice.exception.ResourceNotFoundException;
import com.microservice.tutorial.microservice.repository.AccountCrudRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountCrudRepository accountCrudRepository;

    public void addAccount(Account account) {
        accountCrudRepository.save(account);
    }

    public Account getAccount(int id) {
        try {
            return accountCrudRepository.findByAccountNum(id);
        } catch (Exception e) {
            throw new ResourceNotFoundException("Account", "AccountNum", id);
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

    public Account updateAccount(int accountNum, Account accountInputForm) {

        Account account = getAccount(accountNum);
        if (null != accountInputForm.getAccountType()) {
            account.setAccountType(accountInputForm.getAccountType());
        }
        if (null != accountInputForm.getDob()) {
            account.setDob(accountInputForm.getDob());
        }
        if (null != accountInputForm.getEmail()) {
            account.setEmail(accountInputForm.getEmail());
        }
        if (null != accountInputForm.getFirstName()) {
            account.setFirstName(accountInputForm.getFirstName());
        }
        if (null != accountInputForm.getLastName()) {
            account.setLastName(accountInputForm.getLastName());
        }
        if (null != accountInputForm.getHomeAddress()) {
            account.setHomeAddress(accountInputForm.getHomeAddress());
        }
        if (null != accountInputForm.getMailAddress()) {
            account.setMailAddress(accountInputForm.getMailAddress());
        }
        if (accountInputForm.getMobileNumber() != 0) {
            account.setMobileNumber(accountInputForm.getMobileNumber());
        }
        if (accountInputForm.getSsn() != 0) {
            account.setSsn(accountInputForm.getSsn());
        }

        Account updatedAccount = accountCrudRepository.save(account);
        return updatedAccount;
    }

}
