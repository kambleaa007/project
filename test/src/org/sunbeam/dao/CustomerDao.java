package org.sunbeam.dao;

import org.sunbeam.pojo.Customer;

public interface CustomerDao 
{
	Integer insertCustomer( Customer customer );
	
	Customer validateCustomer( String email, String password );
}
