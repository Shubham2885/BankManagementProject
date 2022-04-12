package com.bz.controller;

import java.util.Scanner;

import com.bz.comman.AccountType;
import com.bz.comman.Validation;
import com.bz.interfaces.IAccountService;
import com.bz.interfaces.ICustomerService;
import com.bz.model.Account;
import com.bz.model.Customer;
import com.bz.services.AccountServiceImpl;
import com.bz.services.CustomerServiceImpl;

public class BankManagementApp {

	static Scanner scanner = new Scanner(System.in);
	static ICustomerService customerService = new CustomerServiceImpl();
	static IAccountService accountService = new AccountServiceImpl();
	
	public static void registerCustomer() {
		
		Customer customer = new Customer();
		System.out.println("Enter the firstName");
		String firstName = scanner.next();
		Validation.checkStartWithCap(firstName);
		customer.setFirstName(firstName);
		
		System.out.println("Enter the middleName");
		String middleName = scanner.next();
		Validation.checkStartWithCap(middleName);
		customer.setMiddleName(middleName);
		
		System.out.println("Enter the lastName");
		String lastName = scanner.next();
		Validation.checkStartWithCap(lastName);
		customer.setLastName(lastName);
		
		System.out.println("Enter the mobileNo");
		String mobileNo = scanner.next();
		Validation.checkMobileNo(mobileNo);
		customer.setMobileNo(mobileNo);
		
		System.out.println("Enter the username");
		String username = scanner.next();
		customer.setUsername(username);
		
		System.out.println("Enter the password");
		String password = scanner.next();
		customer.setPassword(password);
		
		System.out.println("Enter the email");
		String email = scanner.next();
		customer.setEmail(email);
		
		//method call
		int id = customerService.register(customer);
		System.out.println("Your Customer id is "+id);
	}
	
	private static void showAllCustomer() {
		System.out.println(customerService.getAllCustomers());
	}
	
	private static void openAccount() {
		System.out.println("Enter the Customer Id");
		int custId = scanner.nextInt();
		System.out.println("List Account Type");
		System.out.println("1 Saving Account");
		System.out.println("2 Current Account");
		
		System.out.println("Select Acccount type...");
		int choice = scanner.nextInt();
		
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
	public static void main(String[] args) {
		int ch = 1;
		do {
			
			System.out.println("Welcome to Bank");
			System.out.println("A - 1 Register Customer");
			System.out.println("A - 2 Open Account");
			System.out.println("Enter your choice...");
			int choice = scanner.nextInt();
			
			switch (choice) {
			case 1:
				registerCustomer();
				break;
			case 2:
				openAccount();
				break;
			default:
				break;
			}
			
			System.out.println("Do you want to contineu.... press 1");
			ch = scanner.nextInt();
		}while(ch == 1);
	}
	
}

//Customer( id, firstName, middleName, lastName, mobileNo, username, password, email, address _id)
//Address(street, plotNo, town, taluka, district, state, pincode)
//Account(accountNo, ifscNo, branchCode, accountType, balance, branchName, customer_id)
//BankMangementDashboard
//openAccount, debit, credit, banlanceEnquiry, tranferfund
