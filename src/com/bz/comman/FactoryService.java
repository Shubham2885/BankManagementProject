package com.bz.comman;

import com.bz.services.AccountServiceImpl;
import com.bz.services.CustomerServiceImpl;

public class FactoryService {

	private static final FactoryService _INSTANCE = new FactoryService();
	
	public static FactoryService getInstance() {
		return _INSTANCE;
	}
	
	public Object getBean(ObjectCreationEnum creationEnum) {
		
		switch (creationEnum) {
		case CUSTOMERSERVICE: return new CustomerServiceImpl();
		case ACCOUNTSERVICE: return new AccountServiceImpl();	
		default:
			break;
		}
		return null;
	}

}
