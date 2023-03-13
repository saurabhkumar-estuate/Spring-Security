package com.est.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.est.security.models.User;

@Service
public class UserService {
	
	List<User> list= new ArrayList<>();

	public UserService() {
		 
		 list.add(new User("abc","abc","abc@gmail.com"));
		 list.add(new User("xyz","xyzabc","xyz@gmail.com")); 
	}
	
	
	//TO GET ALL THE USER
	public List<User> getAllUsers()
	{
		return this.list;
	}
	
	
	//TO GET SINGLE USER
	public User getUser(String username)
	{
		return this.list.stream()
			    .filter((user) -> user.getUsername().equals(username))
			    .findAny()
			    .get();

	}
	
	public User addUser(User user)
	{
		this.list.add(user);
		return user;
	}
	
	
	
	

}
