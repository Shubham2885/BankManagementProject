package com.bz.interfaces;

import java.util.ArrayList;

import com.bz.model.Customer;

public interface ICustomerService {

	public int register(Customer customer);
	public void update(Customer customer);
	public Customer search(int id);
	public void delete(int id);
	public ArrayList<Customer> getAllCustomers();
}
 