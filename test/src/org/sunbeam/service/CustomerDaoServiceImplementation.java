package org.sunbeam.service;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sunbeam.dao.CustomerDao;
import org.sunbeam.pojo.Customer;

@Service
@Transactional
public class CustomerDaoServiceImplementation implements CustomerService 
{
	@Autowired
	CustomerDao dao;
	public CustomerDaoServiceImplementation(){	
	}
	@Override
	public String insertCustomer(Customer customer) {		
		this.dao.insertCustomer(customer);
		return "success";
	}
	@Override
	public Customer validateCustomer(String email, String password) {
		return dao.validateCustomer(email, password);
	}	
}
