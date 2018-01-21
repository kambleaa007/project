package org.sunbeam.dao;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sunbeam.pojo.User;

@Repository
public class UserDaoImplementation implements UserDao{

	@Autowired
	private SessionFactory sessionFactory; 
	
	@Override
	public Integer insertUser(User user) {
		return (Integer) sessionFactory.getCurrentSession().save(user);		
	}
	
	@Override
	public User validateUser(String name, String password) {
		Query<User> query = sessionFactory.getCurrentSession().createQuery("select u from User u where u.password=:Password and u.name=:Name", User.class);
		query.setParameter("Name", name);
		query.setParameter("Password", password);
		return query.getSingleResult();
		
//		String jpql = "select u from ser u where u.email = :em and u.pass = :pa";
//		return sessionFactory.getCurrentSession().createQuery(jpql, User.class).setParameter("em", em1).setParameter("pa", pass1).getSingleResult();
//		
		
		
	}

	@Override
	public List<User> getUserList() {
		
		List<User> userList = new ArrayList<>();
		
		if(true){
			userList = sessionFactory.getCurrentSession().createQuery(" from User",User.class).getResultList();
			
			return userList;
		}
		
		return null;
	}

	@Override
	public String updateUser(User user) {
		
		sessionFactory.getCurrentSession().update(user);;
		return "Success";
	}

	@Override
	public User getPersonById(Integer id) {
		
		//Query<User> query = sessionFactory.getCurrentSession().createQuery("select u from user u where u.id=:Id", User.class);
		//query.setParameter("Id", (int)id);
		//query.getSingleResult();
		return sessionFactory.getCurrentSession().find(User.class, id);
		 
		
	}

	@Override
	public String removePerson(User user) {
		
		sessionFactory.getCurrentSession().delete(user);
		//sessionFactory.getCurrentSession().delete(getPersonById(id));
		return "Success";
	}
	
	
	
}
