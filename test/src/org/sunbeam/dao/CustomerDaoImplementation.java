package org.sunbeam.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sunbeam.pojo.Customer;

@Repository
public class CustomerDaoImplementation implements CustomerDao{

	@Autowired
	private SessionFactory sessionFactory; 
	@Override
	public Integer insertCustomer(Customer customer) {
		return (Integer) sessionFactory.getCurrentSession().save(customer);		
	}
	@Override
	public Customer validateCustomer(String email, String password) {
		Query<Customer> query = sessionFactory.getCurrentSession().createQuery("select c from Customer c where c.email=:Email and c.password=:Password", Customer.class);
		query.setParameter("Email", email);
		query.setParameter("Password", password);
		return query.getSingleResult();
	}
}
