package com.bz.controller;

import java.util.Scanner;

import com.bz.comman.Validation;
import com.bz.interfaces.ICustomerService;
import com.bz.model.Customer;
import com.bz.services.CustomerServiceImpl;

public class BankManagementApp {

	static Scanner scanner = new Scanner(System.in);
	static ICustomerService customerService = new CustomerServiceImpl();
	
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
		
		customerService.add(customer);
	}
	
	private static void showAllCustomer() {
		System.out.println(customerService.getAllCustomers());
	}
	
	public static void main(String[] args) {
		int ch = 1;
		do {
			
			System.out.println("Welcome to Bank");
			System.out.println("1 Register Customer");
			System.out.println("2 Get All Customer");
			System.out.println("Enter your choice...");
			int choice = scanner.nextInt();
			
			switch (choice) {
			case 1:
				registerCustomer();
				break;
			case 2:
				showAllCustomer();
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
