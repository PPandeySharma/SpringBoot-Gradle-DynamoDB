package com.example.controller;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Person;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.QueryRequest;
import com.example.model.User;


//import com.example.model.UserRepository;

import com.example.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService us;
	
	
    @RequestMapping("/allperson")
	public Hashtable<String,Person> getAllPerson(){
		return us.getAllPerson();
		
	}
	
	@RequestMapping("/person={id}")
	public Person getPerson(@PathVariable("id") String id){
		return us.getPerson(id);
	}
	
	@RequestMapping(value="/newperson", method=RequestMethod.POST)
	@ResponseBody
	public String newPerson( @RequestParam(value = "name", required = false) String name,
                             @RequestParam(value= "age", required = false) Integer age,
                             @RequestParam(value= "email" , required = true) String email,
                             @RequestParam(value= "gender" , required = false) String gender){
		return us.newPerson(name,age,email,gender);
	}
	
	
	@RequestMapping(value="/newuser", method=RequestMethod.POST)
	@ResponseBody
	public String newUser( @RequestParam(value = "name", required = false) String name,
                             @RequestParam(value= "age", required = false) Integer age,
                             @RequestParam(value= "email" , required = true) String email,
                             @RequestParam(value= "gender" , required = false) String gender){
		
		User u = new User();
		u.setAge(age);
		u.setEmail(email);
		u.setName(name);
		u.setGender(gender);
		User newUser =  us.newUser(u);
		
		String message = " Welcome "+newUser.getName();
		return message;
	}
	
	@RequestMapping("/alluser")
	public List<User> getAllUser(){
		return us.getAllUser();
		
	}

}
