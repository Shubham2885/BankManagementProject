package com.bz.services;

import java.util.ArrayList;

import com.bz.exception.CustomException;
import com.bz.interfaces.ICustomerService;
import com.bz.model.Customer;

public class CustomerServiceImpl implements ICustomerService {

	private ArrayList<Customer> listOfCustomer = new ArrayList<Customer>();
	
	@Override
	public int register(Customer customer) {
		int size = listOfCustomer.size();
		int id = 10000 + size;
		customer.setId(id);
		listOfCustomer.add(customer);
		return id;
	}

	@Override
	public void update(Customer customer) {
		// TODO Auto-generated method stub
	}

	@Override
	public Customer search(int id) throws CustomException.CustomerNotFoundException {
		for(Customer customer : listOfCustomer) {
			System.out.println("Customer = "+customer);
			if(customer.getId() == id) {
				System.out.println("Customer is available by id");
				return customer;
			}
		}
		throw new CustomException.CustomerNotFoundException("Customer is not found");
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
