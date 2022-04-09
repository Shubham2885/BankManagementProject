package com.bz.interfaces;

import com.bz.model.Customer;

public interface ICustomerService {

	public void add(Customer customer);
	public void update(Customer customer);
	public Customer search(int id);
	public void delete(int id);
}
