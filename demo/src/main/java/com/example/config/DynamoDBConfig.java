package com.example.config;

import org.springframework.util.StringUtils;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;

@EnableDynamoDBRepositories(basePackages = "com.example.DAO.UserDAO")
@Configuration

public class DynamoDBConfig {
	
	@Value("${amazon.dynamodb.endpoint}") 
	private String amazonDynamoDBEndpoint;

	@Value("${amazon.aws.accesskey}")
	private String amazonAWSAccessKey;
	
	@Value("${amazon.aws.secretkey}")
	private String amazonAWSSecretKey;
	
	@Bean
	public AWSCredentials awsCredentials() {
	  return new BasicAWSCredentials(amazonAWSAccessKey, amazonAWSSecretKey);
	}

	@Bean 
	public AmazonDynamoDB amazonDynamoDB(AWSCredentials awsCredentials) {
	
	  AmazonDynamoDB amazonDynamoDB = new AmazonDynamoDBClient(awsCredentials);
	  if (!StringUtils.isEmpty(amazonDynamoDBEndpoint)) {
	    amazonDynamoDB.setEndpoint(amazonDynamoDBEndpoint);
	  }
	  System.out.println("IN DynamoDBConfig:amazonDynamoDB" );
	  return amazonDynamoDB;
	}
	
	@Bean
	public DynamoDB dynamoDB(AmazonDynamoDB amazonDynamoDB) {
		
		 System.out.println("IN DynamoDBConfig:dynamoDB" );
	  return new DynamoDB(amazonDynamoDB);
	}

}


