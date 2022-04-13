package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.bz.comman.AccountType;
import com.bz.interfaces.IAccountService;
import com.bz.interfaces.ICustomerService;
import com.bz.model.Account;
import com.bz.model.Customer;
import com.bz.services.AccountServiceImpl;
import com.bz.services.CustomerServiceImpl;

public class AccountServiceImplTest {

	IAccountService accountService = new AccountServiceImpl();
	ICustomerService customerService = new CustomerServiceImpl();
	private static final double DELTA = 1e-15;

	@Before
	public void setup() {
		Customer customer1 = new Customer();
		customer1.setFirstName("SHubham");
		customer1.setLastName("Chavan");
		
		Customer customer2 = new Customer();
		customer2.setFirstName("Raj");
		customer2.setLastName("Kawale");
		
		Customer customer3 = new Customer();
		customer3.setFirstName("Nitesh");
		customer3.setLastName("Gupta");
		
		customerService.register(customer1);
		customerService.register(customer2);
		customerService.register(customer3);
		
		Account account = accountService.openAccount(10000, AccountType.Saving, customerService);
		System.out.println(account);
	}
	
	@Test
	public void creditBalanceTest() {
		double bal = accountService.creditBalance(10000, 10010000l, 10000.0, customerService);
		assertEquals(10000.0, bal, DELTA);
	}
}
