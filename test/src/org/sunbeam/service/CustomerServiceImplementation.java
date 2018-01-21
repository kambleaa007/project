package org.sunbeam.service;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.sunbeam.pojo.Customer;


public class CustomerServiceImplementation implements CustomerService 
{
	//private CustomerDaoServiceImplementation dao;
	private static SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
	
	private Map<String, Customer> map;
	public CustomerServiceImplementation() throws Exception{
		this.map = new HashMap<>();
		this.map.put("soham@gmail.com", new Customer(1, "soham", "soham", "soham@gmail.com", "Customer", format.parse("01-12-2007")));
		this.map.put("prathamesh@gmail.com", new Customer(2, "prathamesh", "prathamesh", "prathamesh@gmail.com", "Customer", format.parse("01-12-2006")));
	}
	@Override
	public String insertCustomer(Customer customer) {		
		if( map.containsKey(customer.getEmail()))
			return "fail";
		else
		{
			customer.setId(map.size() + 1 );
			map.put(customer.getEmail(), customer);
			//dao.insertCustomer(customer);
		}			
		return "success";
	}
	@Override
	public Customer validateCustomer(String email, String password) {
		if(map.containsKey(email))
		{
			Customer customer = map.get(email);
			return customer;
		}
		return null;
	}	
}
