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


public class add_comment {
	//when we add comment to a question
	
	public void comment(comments ft,int question_id) throws JsonProcessingException
	{
	
		System.out.println("yes "+ft.getName());
	RestTemplate resttemplate=new RestTemplate();
	questions bt=new questions();
//	comments ft=new comments();
//	ft.
	//questions dt=new questions();
	bt  = resttemplate.getForObject( "http://localhost:8080/findquestionbyid/"+question_id+"", questions.class);
	bt.comments_list.add(ft);
	
	
	String url="http://localhost:8080/update/question";
	RestTemplate rest=new RestTemplate();
	HttpHeaders headers = new HttpHeaders();
	headers.setContentType(MediaType.APPLICATION_JSON);
	final ObjectMapper objectMapper = new ObjectMapper();
	HttpEntity<String> request2 = 
		
			new HttpEntity<String>(objectMapper.writeValueAsString(bt), headers);

	String Result2AsJsonStr = 
			rest.postForObject(url, request2, String.class);
	}
	
	
	

}
