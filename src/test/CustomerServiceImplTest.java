package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.bz.interfaces.ICustomerService;
import com.bz.model.Customer;
import com.bz.services.CustomerServiceImpl;

public class CustomerServiceImplTest {

	ICustomerService customerService = new CustomerServiceImpl();
	
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
		
	}
	
	@Test
	public void searchTest() {
		int custId = 10002;
		
		String name = "Raj";
		
		Customer customer = customerService.search(custId);
		
		assertEquals(name, customer.getFirstName());
	}
}
