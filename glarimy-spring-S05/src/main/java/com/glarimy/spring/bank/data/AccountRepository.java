package com.glarimy.spring.bank.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.glarimy.spring.bank.api.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

}
