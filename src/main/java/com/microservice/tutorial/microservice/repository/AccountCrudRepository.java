package com.microservice.tutorial.microservice.repository;

import com.microservice.tutorial.microservice.dto.Account;

import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountCrudRepository extends CrudRepository<Account, Long> {
    @Nullable
    Account findByAccountNum(int id);

    Boolean deleteByAccountNum(int id);
}
