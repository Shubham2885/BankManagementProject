package com.bz.services;

import java.util.ArrayList;

import com.bz.interfaces.ICustomerService;
import com.bz.model.Customer;

public class CustomerServiceImpl implements ICustomerService {

	private ArrayList<Customer> listOfCustomer = new ArrayList<Customer>();
	
	@Override
	public void add(Customer customer) {
		listOfCustomer.add(customer);
	}

	@Override
	public void update(Customer customer) {
		// TODO Auto-generated method stub
	}

	@Override
	public Customer search(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Customer> getAllCustomers() {
		return listOfCustomer;
	}

}
