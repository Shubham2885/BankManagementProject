package com.bz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bz.model.Customer;

public class CustomerDao implements ICustomerDao {

	private static Connection CONNECTION;
	private static final String insertQuery = "insert into bms_customer(firstName, middleName, lastName, mobileNo, username, password, email, addressId) values(?,?,?,?,?,?,?,?);";
	private static final String searchQuery = "select * from bms_customer where id = ?";
	private static final String latestCustomerQuery = "select max(id) from bms_customer";
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;
	
	public CustomerDao() {
		CONNECTION = DBConnection.getInstance().getConnection();
		try {
			preparedStatement = CONNECTION.prepareStatement(insertQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Customer insertCustomer(final Customer customer) {
		try {
			int cust_id = 0;
			preparedStatement.setString(1, customer.getFirstName());
			preparedStatement.setString(2, customer.getMiddleName());
			preparedStatement.setString(3, customer.getLastName());
			preparedStatement.setString(4, customer.getMobileNo());
			preparedStatement.setString(5, customer.getUsername());
			preparedStatement.setString(6, customer.getPassword());
			preparedStatement.setString(7, customer.getEmail());
			preparedStatement.setInt(8, customer.getAddressId());
			
			int i = preparedStatement.executeUpdate();
			if(i == 1) {
				resultSet = preparedStatement.executeQuery(latestCustomerQuery);
				while(resultSet.next()) {
					cust_id = resultSet.getInt(1);
					
					Customer customer2 = search(cust_id);
					return customer2;
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Customer search(int id) {
		try {
			preparedStatement = CONNECTION.prepareStatement(searchQuery);
			preparedStatement.setInt(1, id);
			
			resultSet = preparedStatement.executeQuery();
			
			Customer customer = new Customer();
			while(resultSet.next()) {
				customer.setId(resultSet.getInt(1));
				customer.setFirstName(resultSet.getString(2));
				customer.setMiddleName(resultSet.getString(3));
				customer.setLastName(resultSet.getString(4));
				customer.setMobileNo(resultSet.getString(5));
				customer.setUsername(resultSet.getString(6));
				customer.setPassword(resultSet.getString(7));
				customer.setEmail(resultSet.getString(8));
				customer.setAddressId(resultSet.getInt(9));
			}
			
			return customer;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
