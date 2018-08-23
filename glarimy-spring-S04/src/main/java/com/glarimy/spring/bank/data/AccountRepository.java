package com.glarimy.spring.bank.data;

import com.glarimy.spring.bank.api.model.Account;

public interface AccountRepository {
	public int save(Account account);
	public Account find(int no);
}
