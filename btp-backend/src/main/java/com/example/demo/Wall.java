package com.example.demo;
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
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.demo.models.questions;

public class Wall {
	
	public List<questions> yoyo()
	{
		RestTemplate resttemplate=new RestTemplate();
		questions u=new questions();
		subreddit sub=new subreddit();
		int i=1;
		List<questions> a=new ArrayList<questions>();
	
		
			
			while(true)
			{
				
				sub=resttemplate.getForObject( "http://localhost:8080/findsubredditbyid/"+i+"", subreddit.class);
				if(sub==null)
				{
					break;
				}
					for(int j=1;;j++)
					{
						int x=i*1000+j;
						u  = resttemplate.getForObject( "http://localhost:8080/findquestionbyid/"+x+"", questions.class);	
							
							if(u==null)
							{
								break;
							}
							a.add(u);
								
					}
					i++;
					
			}
			
			
		System.out.println(a);
	
			return a; 
		
		

	}

}
