package com.example.demo.auth;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.io.BufferedReader;
import java.io.FileReader;
import java.time.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.demo.models.*;

import com.fasterxml.jackson.core.JsonProcessingException;

public class AdminLogin {

	MongoTemplate mongoTemplate;
	RestTemplate resttemplate=new RestTemplate();
	
	public int yoyo(String name, String password) throws JsonProcessingException
	{
		
//		user at=new user();
//		
//		at  = resttemplate.getForObject( "http://localhost:8080/finduserbyusername/"+name+"", user.class);
//		
//		if(at==null)return 0;
	
		if(name.compareTo("Admin1")==0)
		{
			if(password.compareTo("Admin@123")==0)
			{
				System.out.println("Admin yes");
				 return 1;
		
			}
			else {
				return 0;
			}
		}
		else
		{
			return 0;
			//user not authenticated
		}
		
	}
}
