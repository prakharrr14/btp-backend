//package com.example.demo.subreddit;
//
//import java.util.*;
//import java.util.concurrent.TimeUnit;
//import java.util.stream.Collectors;
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.time.*;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.query.Criteria;
//import org.springframework.data.mongodb.core.query.Query;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.client.RestTemplate;
//
//import com.example.demo.models.comments;
//import com.example.demo.models.questions;
//import com.example.demo.models.subreddit;
//import com.example.demo.models.user;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//public class add_subreddit
//{
//
//	public String yo(String user_id,String name) throws JsonProcessingException
//	{
//		RestTemplate resttemplate=new RestTemplate();
//		subreddit bt=new subreddit();
//		int i=0;
//		
//	
//			for(i=1;;i++)
//			{
//				bt  = resttemplate.getForObject( "http://localhost:8080/findsubredditbyid/"+i+"", subreddit.class);
//				if(bt==null)
//				{
//					System.out.println("yahan aaye kya");
//					break;
//				}
//			}
//		
//		
////		catch(Exception e){
//			//questions collection updated
//			//how are tags be sent
//			System.out.println("this isi "+i);
//			subreddit rt=new subreddit();
//			rt.setId(i);
//			rt.setName(name);
//			rt.setUrl("/parentforum/"+i+"");
//			rt.tags_list=new ArrayList<String>();
////			rt.users_list=new ArrayList<String>();
//			rt.tags_list.add("jnj");
//			
//			
//			try {
//				rt.users_list.add(user_id);
//				}
//				catch(Exception e){
//					rt.users_list=new ArrayList<String>();
//					rt.users_list.add(user_id);
//				}
//			
//			
//			RestTemplate rest=new RestTemplate();
//			HttpHeaders headers = new HttpHeaders();
//			String url1="http://localhost:8080/add/subreddit";
//			headers.setContentType(MediaType.APPLICATION_JSON);
//			final ObjectMapper objectMapper = new ObjectMapper();
//			
//			HttpEntity<String> request2 = 
//					new HttpEntity<String>(objectMapper.writeValueAsString(rt), headers);
//
//			String Result2AsJsonStr = 
//					rest.postForObject(url1, request2, String.class);
//			
//			
//			System.out.println("aaye");
//			//user collection update
//			
//			user us=new user();
//			us  = resttemplate.getForObject( "http://localhost:8080/finduserbyusername/"+user_id+"", user.class);
//			us.subreddit_id_list.add(i);
//			//String url2="http://localhost:8080/add_question_id_user";
//			String url2="http://localhost:8080/update/user";
//			 request2 = 
//					new HttpEntity<String>(objectMapper.writeValueAsString(us), headers);
//
//			Result2AsJsonStr = 
//					rest.postForObject(url2, request2, String.class);
////					rest.put(url2, request2);
//			//give the value of i
//		
//		
////	}
//		return "/"+user_id+"";
//	}
//	
//}
//	
//


package com.example.demo.subreddit;

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
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.demo.models.comments;
import com.example.demo.models.questions;
import com.example.demo.models.subreddit;
import com.example.demo.models.user;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
public class add_subreddit
{

	public int yo(String user_id,String name) throws JsonProcessingException
	{
		RestTemplate resttemplate=new RestTemplate();
		subreddit bt=new subreddit();
		int i=0;
		
	
			for(i=1;;i++)
			{
				bt  = resttemplate.getForObject( "http://localhost:8080/findsubredditbyid/"+i+"", subreddit.class);
				if(bt==null)
				{
					System.out.println("yahan aaye kya");
					break;
				}
			}
		
		
//		catch(Exception e){
			//questions collection updated
			//how are tags be sent
			System.out.println("this isi "+i);
			subreddit rt=new subreddit();
			rt.setId(i);
			rt.setName(name);
			rt.setUrl("/parentforum/"+i+"");
			rt.tags_list=new ArrayList<String>();
//			rt.users_list=new ArrayList<String>();
			rt.tags_list.add("jnj");
			
			
			try {
				rt.users_list.add(user_id);
				}
				catch(Exception e){
					rt.users_list=new ArrayList<String>();
					rt.users_list.add(user_id);
				}
			
			
			RestTemplate rest=new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			String url1="http://localhost:8080/add/subreddit";
			headers.setContentType(MediaType.APPLICATION_JSON);
			final ObjectMapper objectMapper = new ObjectMapper();
			
			HttpEntity<String> request2 = 
					new HttpEntity<String>(objectMapper.writeValueAsString(rt), headers);

			String Result2AsJsonStr = 
					rest.postForObject(url1, request2, String.class);
			
			
			System.out.println("aaye");
			//user collection update
			
			user us=new user();
			us  = resttemplate.getForObject( "http://localhost:8080/finduserbyusername/"+user_id+"", user.class);
			us.subreddit_id_list.add(i);
			//String url2="http://localhost:8080/add_question_id_user";
			String url2="http://localhost:8080/update/user";
			 request2 = 
					new HttpEntity<String>(objectMapper.writeValueAsString(us), headers);

			Result2AsJsonStr = 
					rest.postForObject(url2, request2, String.class);
//					rest.put(url2, request2);
			//give the value of i
		
		
//	}
		return i;
	}
	
}
