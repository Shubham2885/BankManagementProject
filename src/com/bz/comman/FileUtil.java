package com.bz.comman;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.bz.model.Customer;
import com.google.gson.Gson;

public class FileUtil {

	final static String CUSTOMER_JSON_FILE = "customer_json.json";
	
	private static File file;
	private static Gson gson;
	
	public FileUtil() {
		
		file = new File(CUSTOMER_JSON_FILE);
		gson = new Gson();
	}
	
	public void write(Customer customer) throws IOException {
		List<Customer> listCustomers = read();
		listCustomers.add(customer);
		String jsonStirng = gson.toJson(listCustomers);
		System.out.println("JSON String = "+jsonStirng);
		FileWriter fileWriter = new FileWriter(file);
		fileWriter.write(jsonStirng);
		System.out.println("Data is inserted");
		fileWriter.close();
	}
	
	public List<Customer> read() {
		try {
			if(file.exists()) {
				BufferedReader bufferedReader = new BufferedReader(new FileReader(CUSTOMER_JSON_FILE));
				Customer[] customers = gson.fromJson(bufferedReader, Customer[].class);
				List<Customer> customerList = new ArrayList<Customer>();
				if(customers != null) {
					List<Customer> customerList1 = Arrays.asList(customers);
					for(Customer customer : customerList1) {
						customerList.add(customer);
					}
					System.out.println(customerList);
				}
				return customerList;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
