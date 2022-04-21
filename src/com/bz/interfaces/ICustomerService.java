package com.bz.interfaces;

import java.util.ArrayList;
import java.util.List;

import com.bz.exception.CustomException;
import com.bz.model.Customer;

public interface ICustomerService {

	public int register(Customer customer);
	public void update(Customer customer);
	public Customer search(int id) throws CustomException.CustomerNotFoundException;
	public void delete(int id);
	public List<Customer> getAllCustomers();
}
 