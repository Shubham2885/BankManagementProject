package com.bz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bz.model.Account;

public class AccountDao implements IAccountDao {

	private static Connection CONNECTION;
	private static String insertQuery = "insert into bms_account(ifscNo, branchCode, accountType, balance, branchName, customer_id) values(?,?,?,?,?,?);";
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;
	private static final String latestAccountQuery = "select max(accountNo) from bms_account";
	
	public AccountDao() {
		CONNECTION = DBConnection.getInstance().getConnection();
		try {
			preparedStatement = CONNECTION.prepareStatement(insertQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Account insertAccount(Account account) {
try {
			
			preparedStatement.setString(1, account.getIfscNo());
			preparedStatement.setString(2, account.getBranchCode());
			preparedStatement.setString(3, account.getAccountType());
			preparedStatement.setDouble(4, account.getBalance());
			preparedStatement.setString(5, account.getBranchName());
			preparedStatement.setInt(6, account.getCustomer_id());
			
			int i = preparedStatement.executeUpdate();
			
			if(i == 1) {
				resultSet = preparedStatement.executeQuery(latestAccountQuery);
				account.setAccountNo(resultSet.getInt(1));
				return account;
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
