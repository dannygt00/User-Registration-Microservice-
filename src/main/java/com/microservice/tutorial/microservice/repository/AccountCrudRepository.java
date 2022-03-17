package com.microservice.tutorial.microservice.repository;

import com.microservice.tutorial.microservice.dto.Account;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountCrudRepository extends CrudRepository<Account, Integer> {
    Account findByAccountNum(int id);
}
