package com.bz.controller;

import java.util.Scanner;

import com.bz.comman.AccountType;
import com.bz.comman.ScannerUtil;
import com.bz.comman.Validation;
import com.bz.interfaces.IAccountService;
import com.bz.interfaces.ICustomerService;
import com.bz.model.Account;
import com.bz.model.Customer;
import com.bz.services.AccountServiceImpl;
import com.bz.services.CustomerServiceImpl;

public class BankManagementApp {

	static ICustomerService customerService = new CustomerServiceImpl();
	static IAccountService accountService = new AccountServiceImpl();
	
	public static void registerCustomer() {
		
		Customer customer = new Customer();
		String firstName = ScannerUtil.getString("firstName");
		Validation.checkStartWithCap(firstName);
		customer.setFirstName(firstName);
		
		String middleName = ScannerUtil.getString("middleName");
		Validation.checkStartWithCap(middleName);
		customer.setMiddleName(middleName);
		
		String lastName = ScannerUtil.getString("lastName");
		Validation.checkStartWithCap(lastName);
		customer.setLastName(lastName);
		
		String mobileNo = ScannerUtil.getString("mobileNo");
		Validation.checkMobileNo(mobileNo);
		customer.setMobileNo(mobileNo);
		
		String username = ScannerUtil.getString("username");
		customer.setUsername(username);
		
		String password = ScannerUtil.getString("password");
		customer.setPassword(password);
		
		String email = ScannerUtil.getString("email");
		customer.setEmail(email);
		
		//method call
		int id = customerService.register(customer);
		System.out.println("Your Customer id is "+id);
	}
	
	private static void showAllCustomer() {
		System.out.println(customerService.getAllCustomers());
	}
	
	private static void openAccount() {
		int custId = ScannerUtil.getInt("Customer Id");
		System.out.println("List Account Type");
		System.out.println("1 Saving Account");
		System.out.println("2 Current Account");
		
		int choice = ScannerUtil.getInt("Acccount type...");
		
		AccountType accountType = AccountType.Basic;
		switch (choice) {
		case 1:
			accountType = AccountType.Saving;
			break;
		case 2:
			accountType = AccountType.Current;
			break;
		default:
			break;
		}
		Account account = accountService.openAccount(custId, accountType, customerService);
		System.out.println("New Account is Create ");
		System.out.println("****************************************");
		System.out.println("Account No :"+account.getAccountNo());
		System.out.println("IFSC Code : "+account.getIfscNo());
		System.out.println("Balance  :"+account.getBalance());
		
	}
	
	private static void debitBalance() {
		// TODO Auto-generated method stub
		
	}

	private static void creditBalance() {
		int custId = ScannerUtil.getInt("Customer id");
		long accountNo = ScannerUtil.getLong("Account No");
		double balance = ScannerUtil.getDouble("Balance");
		double newBalance = accountService.creditBalance(custId, accountNo, balance, customerService);
		System.out.println("*****************************************");
		System.out.println("your New Balance is "+newBalance);
		System.out.println("*****************************************");
	}
	
	public static void main(String[] args) {
		int ch = 1;
		do {
			
			System.out.println("Welcome to Bank");
			System.out.println("A - 1 Register Customer");
			System.out.println("A - 2 Open Account");
			System.out.println("A - 3 Credit Balance");
			System.out.println("A - 4 Debit Balance");
			int choice = ScannerUtil.getInt("choice...");
			
			switch (choice) {
			case 1:
				registerCustomer();
				break;
			case 2:
				openAccount();
				break;
			case 3:
				creditBalance();
				break;
			case 4:
				debitBalance();
				break;
			default:
				break;
			}
			
			ch = ScannerUtil.getInt("Do you want to contineu.... press 1");
		}while(ch == 1);
	}
	
}

//Customer( id, firstName, middleName, lastName, mobileNo, username, password, email, address _id)
//Address(street, plotNo, town, taluka, district, state, pincode)
//Account(accountNo, ifscNo, branchCode, accountType, balance, branchName, customer_id)
//BankMangementDashboard
//openAccount, debit, credit, banlanceEnquiry, tranferfund
