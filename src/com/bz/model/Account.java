package com.bz.model;

public class Account {
	
	private long accountNo;
	private String ifscNo;
	private String branchCode;
	private String accountType;
	private double balance;
	private String branchName;
	private int customer_id;
	public long getAccountNo() {
		
		
		return accountNo;
	}
	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}
	public String getIfscNo() {
		return ifscNo;
	}
	public void setIfscNo(String ifscNo) {
		this.ifscNo = ifscNo;
	}
	public String getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	
	
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", ifscNo=" + ifscNo + ", branchCode=" + branchCode
				+ ", accountType=" + accountType + ", balance=" + balance + ", branchName=" + branchName
				+ ", customer_id=" + customer_id + "]";
	}
	
}
	


