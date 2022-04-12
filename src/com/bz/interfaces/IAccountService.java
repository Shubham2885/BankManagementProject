package com.bz.interfaces;

import com.bz.comman.AccountType;
import com.bz.model.Account;

public interface IAccountService {

	public Account openAccount(int customerId, AccountType accountType, ICustomerService customerService);
}
