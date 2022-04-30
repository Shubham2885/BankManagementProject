package com.bz.dao;

import com.bz.model.Customer;

public interface ICustomerDao {

	Customer insertCustomer(Customer customer);
	Customer search(int id);
}
