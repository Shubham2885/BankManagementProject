package com.bz.services;

import java.util.ArrayList;

import com.bz.comman.AccountType;
import com.bz.interfaces.IAccountService;
import com.bz.interfaces.ICustomerService;
import com.bz.model.Account;
import com.bz.model.Customer;

public class AccountServiceImpl implements IAccountService {

	
	private ArrayList<Account> accounts = new ArrayList<Account>();
	private final static String IFSC = "SBIN00012";
	private final static String BRANCH_CODE = "SBIN00012";
	private final static String BRANCH_NAME = "SBIN00012";
	
	@Override
	public Account openAccount(int customerId, AccountType accountType, ICustomerService customerService) {
		
		Customer customer = customerService.search(customerId);
		if(customer != null) {
			Account account = new Account();
			long accountNo = 10000000 + customer.getId() + accounts.size();
			account.setAccountNo(accountNo);
			account.setIfscNo(IFSC);
			account.setAccountType(accountType.toString());
			account.setCustomer_id(customerId);
			account.setBranchName(BRANCH_NAME);
			account.setBranchCode(BRANCH_CODE);
			account.setBalance(0.0);
			return account;
		}
		System.out.println("Account is not generated due invalid customer id");
		return null;
	}

}
