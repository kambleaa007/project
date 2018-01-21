package org.sunbeam.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.sunbeam.pojo.JobSeeker;
import org.sunbeam.pojo.User;

@Repository
@Transactional
public class JobSeekerDao {

	@Autowired
	private SessionFactory sessionFactory; 
	
	
	
	//.................................. NEW WAY
	
	@PersistenceContext
	EntityManager entityManager;
	
	public List<JobSeeker> findAll() {
		TypedQuery<JobSeeker> q  = entityManager.createQuery("select p from JobSeeker p", JobSeeker.class);
		return q.getResultList();
	}
	
	public JobSeeker findById(int id) {
		return entityManager.find(JobSeeker.class, id);// JPA
	}

	public JobSeeker update(JobSeeker person) {
		return entityManager.merge(person);
	}

	public JobSeeker insert(JobSeeker person) {
		return entityManager.merge(person);
	}

	public void deleteById(int id) {
		JobSeeker person = findById(id);
		entityManager.remove(person);
	}
	
	
	//.................................. NEW WAY
	
	
	
	
	
	
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
	
	
	
	
	
	// .................................................................
	
	// old way
	
	
	
	public Integer insertUser(JobSeeker user) {
		return (Integer) sessionFactory.getCurrentSession().save(user);		
	}
	
	
	public List<JobSeeker> getUserList() {
		
		List<JobSeeker> userList = new ArrayList<>();
		
		if(true){
			userList = sessionFactory.getCurrentSession().createQuery(" from JobSeeker",JobSeeker.class).getResultList();
			
			return userList;
		}
		
		return null;
	}

	public String updateUser(JobSeeker user) {
		
		sessionFactory.getCurrentSession().update(user);;
		return "Success";
	}

	public JobSeeker getPersonById(Integer id) {
		
		//Query<User> query = sessionFactory.getCurrentSession().createQuery("select u from user u where u.id=:Id", User.class);
		//query.setParameter("Id", (int)id);
		//query.getSingleResult();
		return sessionFactory.getCurrentSession().find(JobSeeker.class, id);
		 
		
	}

	public String removePerson(Integer id) {
		
		sessionFactory.getCurrentSession().delete(this.getPersonById(id));
		//sessionFactory.getCurrentSession().delete(getPersonById(id));
		return "Success";
	}
	
	
	// .................................................................
	
		// old way
	
	
}
