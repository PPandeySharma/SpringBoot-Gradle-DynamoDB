package com.example.service;

import java.util.Hashtable;
import java.util.List;

import com.example.model.Person;
import com.example.model.User;

public interface UserService {
	
	//User is data stored in DynamoDB table - 'UserTable'
	
	 public User newUser(User user);
		
	 public List<User> getAllUser();
	 
	 //Person is data stored in Hashtable
	 
	 public Hashtable<String,Person> getAllPerson();
	 
	 public String newPerson(String name, Integer age, String email, String gender);
	 
	 public Person getPerson(String id);

}
