package org.sunbeam.service;

import java.util.List;

import org.sunbeam.pojo.User;

public interface UserService
{
	String insertUser( User  user);
	User validateUser( String email, String password);
	
	List<User> getUserList();
	String updateUser(User user);
	
	User getPersonById(Integer id);
	String removePerson(Integer id);
}
