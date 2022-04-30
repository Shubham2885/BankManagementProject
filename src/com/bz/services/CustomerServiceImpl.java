package com.bz.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.bz.comman.FileUtil;
import com.bz.dao.CustomerDao;
import com.bz.dao.ICustomerDao;
import com.bz.exception.CustomException;
import com.bz.interfaces.ICustomerService;
import com.bz.model.Customer;

public class CustomerServiceImpl implements ICustomerService {
	
//	private FileUtil fileUtil = new FileUtil();
	private ICustomerDao dao = new CustomerDao();
	
	@Override
	public int register(Customer customer) {
//		int size = fileUtil.read().size();
//		int id = 10000 + size;
//		customer.setId(id);
//		try {
//			fileUtil.write(customer);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		Customer customer2 = dao.insertCustomer(customer);
		return customer2.getId();
	}

	@Override
	public void update(Customer customer) {
		// TODO Auto-generated method stub
	}

	//we have use Java Stream API
	@Override
	public Customer search(int id) throws CustomException.CustomerNotFoundException {
//		return fileUtil.read().stream().filter(data -> data.getId() == id).findAny().orElseThrow(() -> new CustomException.CustomerNotFoundException("Customer is not found"));
		return dao.search(id);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Customer> getAllCustomers() {
//		return fileUtil.read();
		return null;
	}

}
