package com.glarimy.spring.bank.data;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.glarimy.spring.bank.api.model.Account;

@Repository
public class BankAccountRepository implements AccountRepository {
	private Map<Integer, Account> ledger;
	private int ACC_ID = 2310;

	public BankAccountRepository() {
		ledger = new HashMap<>();
	}

	@Override
	public int save(Account account) {
		if (account == null)
			throw new AccountRepositoryException();
		account.setNo(ACC_ID++);
		ledger.put(account.getNo(), account);
		return account.getNo();
	}

	@Override
	public Account find(int no) {
		return ledger.get(no);
	}

}
