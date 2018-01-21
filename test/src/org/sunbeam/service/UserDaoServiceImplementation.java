package org.sunbeam.service;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sunbeam.dao.UserDao;
import org.sunbeam.pojo.User;

@Service
@Transactional
public class UserDaoServiceImplementation implements UserService 
{
	@Autowired
	UserDao dao;
	public UserDaoServiceImplementation(){	
	}
	@Override
	public String insertUser(User user) {		
		this.dao.insertUser(user);
		return "success";
	}
	@Override
	public User validateUser(String name, String password) {
		return dao.validateUser(name, password);
	}
	@Override
	public List<User> getUserList() {
		
		return dao.getUserList();
	}
	@Override
	public String updateUser(User user) {
		
		dao.updateUser(user);
		return "Success";
	}
	@Override
	public User getPersonById(Integer id) {
		
		return  dao.getPersonById(id);
		
	}
	@Override
	public String removePerson(Integer id) {
		dao.removePerson(dao.getPersonById(id));
		return "Success";
	}	
}
