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
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class delete_Comment {
	//when we want to delete a comment to a question
	
		public void comment(comments com,int question_id) throws JsonProcessingException
		{
		
		System.out.println("yes "+com.getName());
		RestTemplate resttemplate=new RestTemplate();
		questions q=new questions();
		q  = resttemplate.getForObject( "http://localhost:8080/findquestionbyid/"+question_id+"", questions.class);
		System.out.println(""+q.comments_list.size());
		for(int i=0;i<q.comments_list.size();i++) {
			if(q.comments_list.get(i).getName().equals(com.getName())) {
				q.comments_list.remove(i);
				break;
			}
		}
		System.out.println(""+q.comments_list.size());
		
		String url="http://localhost:8080/update/question";
		RestTemplate rest=new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		final ObjectMapper objectMapper = new ObjectMapper();
		HttpEntity<String> request2 = 
			
				new HttpEntity<String>(objectMapper.writeValueAsString(q), headers);

		String Result2AsJsonStr = 
				rest.postForObject(url, request2, String.class);
		}
		
		
		
}
