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


import com.example.demo.models.questions;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class vote {
	
	
	public void voter(int i,int question_id) throws JsonProcessingException
	{	
		RestTemplate resttemplate=new RestTemplate();
		questions bt=new questions();
		bt  = resttemplate.getForObject( "http://localhost:8080/findquestionbyid/"+question_id+"", questions.class);
		bt.setVotes(bt.getVotes()+i);
		
		String url="http://localhost:8080/update/question";
		RestTemplate rest=new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		 ObjectMapper objectMapper = new ObjectMapper();
		HttpEntity<String> request2 = 
				new HttpEntity<String>(objectMapper.writeValueAsString(bt), headers);

		String Result2AsJsonStr = 
				rest.postForObject(url, request2, String.class);
	}

}
