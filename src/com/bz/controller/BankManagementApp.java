package com.bz.controller;

public class BankManagementApp {
	public void openAccount(int id, String firstName, String middleName, String lastName, int addressId, long depositMoney){

	}
	public void debitAmount(long accountNumber, long amount, int pin){

	}
	public void creditAmount(long accountNumber, long amount, int pin){

	}
	public void balanceEnquiry(long accountNumber,int pin){

	}
	public void transferFund(long accountNumber, long amount, long recipientAccountNum, String recipientIfscCode, int pin){

	}

	public static void main(String[] args) {



	}
}

//Customer( id, firstName, middleName, lastName, mobileNo, username, password, email, address _id)
//Address(street, plotNo, town, taluka, district, state, pincode)
//Account(accountNo, ifscNo, branchCode, accountType, balance, branchName, customer_id)
//BankMangementDashboard
//openAccount, debit, credit, banlanceEnquiry, tranferfund
