package org.sunbeam.dao;

import java.util.List;

import org.sunbeam.pojo.User;

public interface UserDao 
{
	Integer insertUser( User user );
	
	User validateUser( String name, String email );
	
	List<User> getUserList();
	
	String updateUser(User user);
	
	User getPersonById(Integer id);
	
	String removePerson(User user);
}
