package com.example.demo.auth;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.io.BufferedReader;
import java.io.FileReader;
import java.time.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import com.example.demo.models.*;
import com.fasterxml.jackson.databind.ObjectMapper;
public class signup 
{
	
	public void main()
	{
		JSONObject obj0 = new JSONObject();
		//just make sure to get these from the front end
		String username="";
		String password="";
		String user_type="";
		String email_id="";
		JSONArray list0 = new JSONArray();	  
		JSONArray list1 = new JSONArray();
		
		obj0.put("username", username);
		obj0.put("password", username);
		obj0.put("usertype", username);
		obj0.put("email_id", username);
		obj0.put("subreddit_id_list",list0);
		obj0.put("question_id_list",list1);
		
		
		String url="http://localhost:8080/add/user";
		RestTemplate rest=new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		final ObjectMapper objectMapper = new ObjectMapper();
		HttpEntity<String> request2 = 
				new HttpEntity<String>(obj0.toString(), headers);

		String Result2AsJsonStr = 
				rest.postForObject(url, request2, String.class);

	
	}
	
	
}
