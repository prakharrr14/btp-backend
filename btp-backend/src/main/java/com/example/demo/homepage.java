package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.demo.auth.Sample;
import com.example.demo.auth.Sampler;
import com.example.demo.models.questions;
import com.example.demo.models.subreddit;
import com.example.demo.models.user;


public class homepage {
	
	public List<questions> a(String username)
	{
		RestTemplate resttemplate=new RestTemplate();

		
		user at=new user();
		at=resttemplate.getForObject( "http://localhost:8080/finduserbyusername/"+username+"", user.class);
		questions bt=new questions();
	
		List<questions> a=new ArrayList<questions>();
		
		Sampler list=new Sampler();
	
		for(int i=0;i<at.question_id_list.size();i++)
		{
			Sample temp=new Sample();

			bt  = resttemplate.getForObject( "http://localhost:8080/findquestionbyid/"+at.question_id_list.get(i)+"", questions.class);
			
			temp.question=bt.getName();
			temp.url=bt.getUrl();
			
			 list.lister1.add(temp);
			 a.add(bt);
		}
		
		

//		
		return a;
	}

}
