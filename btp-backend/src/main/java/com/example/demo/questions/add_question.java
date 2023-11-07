package com.example.demo.questions;

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
public class add_question 
{

	public String yo(int subreddit_id,String user_id,String Question,String Question_description) throws JsonProcessingException
	{
		
		RestTemplate resttemplate=new RestTemplate();
		questions bt=new questions();
		int i=0;
		
			for(i=1;;i++)
			{
				int x=subreddit_id*1000+i;
				bt  = resttemplate.getForObject( "http://localhost:8080/findquestionbyid/"+x+"", questions.class);
				if(bt==null)
				{
					break;
				}
			}
		
			//questions collection updated
			//how are tags be sent
			questions rt=new questions();
			rt.setId(subreddit_id*1000+(i));
			rt.setName(Question);
			rt.setUrl("/users/"+i+"");
			rt.setVotes(0);
			
			rt.setQuestion_description(Question_description);
			rt.comments_list=new ArrayList<comments>();
			rt.comments_list.add(null);
			
			RestTemplate rest=new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			String url1="http://localhost:8080/add/question";
			headers.setContentType(MediaType.APPLICATION_JSON);
			final ObjectMapper objectMapper = new ObjectMapper();
			
			
			//user collection update
			
			user us=new user();
			us  = resttemplate.getForObject( "http://localhost:8080/finduserbyusername/"+user_id+"", user.class);
			try {
			us.question_id_list.add(subreddit_id*1000+(i));
			}
			catch(Exception e){
				
				us.question_id_list=new ArrayList<Integer>();
				us.question_id_list.add(subreddit_id*1000+(i));
			}
			
//			String url2="http://localhost:8080/add_question_id_user";
			String url2="http://localhost:8080/update/user";
			HttpEntity<String> request2 = 
					new HttpEntity<String>(objectMapper.writeValueAsString(us), headers);

			 String Result2AsJsonStr = 
					rest.postForObject(url2, request2, String.class);
			
			//subreddit update
			
			subreddit sub=new subreddit();
			sub = resttemplate.getForObject( "http://localhost:8080/findsubredditbyid/"+subreddit_id+"", subreddit.class);
//			sub.question_id_list=new ArrayList<Integer>();
			try {
			sub.question_id_list.add(subreddit_id*1000+(i));
			}
			catch(Exception e)
			{
				sub.question_id_list=new ArrayList<Integer>();
				sub.question_id_list.add(subreddit_id*1000+(i));
			}
//			String url3="http://localhost:8080/add_question_id_subreddit";
			String url3="http://localhost:8080/update/subreddit";
			 request2 = 
					new HttpEntity<String>(objectMapper.writeValueAsString(sub), headers);

			Result2AsJsonStr = 
					rest.postForObject(url3, request2, String.class);
			
			
			rt.setSubreddit_name(sub.getName());
			rt.setSubreddit_url(sub.getUrl());
			
			 request2 = 
					new HttpEntity<String>(objectMapper.writeValueAsString(rt), headers);

			 Result2AsJsonStr = 
					rest.postForObject(url1, request2, String.class);
			
			//give the value of i
		
		return "added question";
	}
	
}
	

