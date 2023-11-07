package com.example.demo.auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//@Service
public class Sample_operator
{
	
	public String ax(Sampler a) throws JsonProcessingException
	{
//     List<Sample> a=new ArrayList<Sample>();
//	
//		Sample x=new Sample();
//		Sample y=new Sample();
//		a.add(x);
//		a.add(y);
		
		ObjectMapper Obj = new ObjectMapper();
		
		String ar=Obj.writeValueAsString(a);
		
		System.out.println(ar);
	  return ar;
	}
}