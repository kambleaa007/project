package org.sunbeam.dao;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.sunbeam.pojo.Company;
import org.sunbeam.pojo.JobSeeker;
import org.sunbeam.pojo.User;

@Repository
@Transactional
public class CompanyDao {

	@Autowired
	private SessionFactory sessionFactory; 
	
	
	public Integer insertUser(Company user) {
		return (Integer) sessionFactory.getCurrentSession().save(user);		
	}
	
//	@Override
//	public User validateUser(String name, String password) {
//		Query<User> query = sessionFactory.getCurrentSession().createQuery("select u from User u where u.password=:Password and u.name=:Name", User.class);
//		query.setParameter("Name", name);
//		query.setParameter("Password", password);
//		return query.getSingleResult();
//		
////		String jpql = "select u from ser u where u.email = :em and u.pass = :pa";
////		return sessionFactory.getCurrentSession().createQuery(jpql, User.class).setParameter("em", em1).setParameter("pa", pass1).getSingleResult();
////		
//		
//		
//	}

	
	public List<Company> getUserList() {
		
		List<Company> userList = new ArrayList<>();
		
		if(true){
			userList = sessionFactory.getCurrentSession().createQuery(" from Company",Company.class).getResultList();
			
			return userList;
		}
		
		return null;
	}

	public String updateUser(Company user) {
		
		sessionFactory.getCurrentSession().update(user);;
		return "Success";
	}

	public Company getPersonById(Integer id) {
		
		//Query<User> query = sessionFactory.getCurrentSession().createQuery("select u from user u where u.id=:Id", User.class);
		//query.setParameter("Id", (int)id);
		//query.getSingleResult();
		return sessionFactory.getCurrentSession().find(Company.class, id);
		 
		
	}

	public String removePerson(Integer id) {
		
		sessionFactory.getCurrentSession().delete(this.getPersonById(id));
		//sessionFactory.getCurrentSession().delete(getPersonById(id));
		return "Success";
	}
	
	
	
}
