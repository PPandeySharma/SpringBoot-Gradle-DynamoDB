package com.example.service;


import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;



import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazonaws.services.dynamodbv2.document.QueryOutcome;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.PutItemRequest;
import com.amazonaws.services.dynamodbv2.model.PutItemResult;
import com.amazonaws.services.dynamodbv2.model.QueryRequest;
import com.amazonaws.services.dynamodbv2.model.QueryResult;
import com.example.DAO.UserDAO;
import com.example.config.DynamoDBConfig;
import com.example.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl  implements UserService {
	
	Hashtable<String,Person> persons = new Hashtable<String,Person>();
	
    //@Autowired
	public UserDAO userDao;
	
	public UserServiceImpl(){
	   
		Person u = new Person();
		u.setId("1");
		u.setEmail("johndoe11@person.com");
		u.setFirstName("John");
		u.setLastName("Doe");
		persons.put("1", u);
		
		
		Person u1 = new Person();
		u1.setId("2");
		u1.setEmail("donaldtrump@person.com");
		u1.setFirstName("Donald");
		u1.setLastName("TRump");
		persons.put("2", u1);
		
		
	}
	
	 //newPerson(),getPerson() and getAllPerson() will be used for hardcoded values in Hashtable 
	
	public Person getPerson(String id){
		
		if (persons.containsKey(id))
			return persons.get(id);
		else 
			return null;
	}
	
	
    public Hashtable<String,Person> getAllPerson(){
		return persons;
	
		
	}
    
   public String newPerson(String name, Integer age, String email, String gender){
		
			return "Person Created   name = "+ name +" age = "+ age+ " email = "+email+ " gender= "+ gender;
	}
   
   //newUser() and getAllUser() will be used to create and fetch data in UserTable in DynamoDB
   
   public User newUser(User user) {
	    return userDao.save(user);
	  }
   
   public List<User> getAllUser(){
	    System.out.println("COMING HERE");
		return (List<User>) userDao.findAll();
	
		
	}
	
	
	
}
