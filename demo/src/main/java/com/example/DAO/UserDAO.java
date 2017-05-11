package com.example.DAO;

import com.example.model.User;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
	
@EnableScan
public interface UserDAO extends CrudRepository<User, String> {}
	
	
	

