//package com.example.demo;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Example;
//import org.springframework.data.mongodb.core.query.Criteria;
//import org.springframework.data.mongodb.core.query.Query;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//
//import com.example.demo.*;
//import com.example.demo.auth.login;
//import com.example.demo.models.comments;
//import com.example.demo.models.questions;
//import com.example.demo.models.subreddit;
//import com.example.demo.models.user;
//import com.example.demo.questions.add_question;
//import com.example.demo.questions.vote;
//import com.example.demo.subreddit.add_subreddit;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.example.demo.questions.add_comment;
//
////import com.example.interfaces.Category_interface;
////import com.example.interfaces.Filter_interface;
////
////import com.example.interfaces.Mart_interface;
////import com.example.interfaces.Section_interface;
////import com.example.interfaces.Subcategory_interface;
////import com.example.interfaces.Subfilter_interface;
////import com.example.demo.model.Hell;
//
//@CrossOrigin(origins = "http://localhost:4001")
//@RestController
//public class restcontroller {
//	
//	
//	RestTemplate rest=new RestTemplate();
//	HttpHeaders headers = new HttpHeaders();
//
//
//    //Hell Hell=new Hell(5);
//	
//	@GetMapping("/wall")
//	public List<questions> retrieveAllQuestions() 
//    {
//        //console.log('executed service')
//		Wall a=new Wall();
//        return a.yoyo();
//    }
//	
////	@PostMapping("/add_user")
////    public String new_user(@RequestBody user User)
////    {
////		
////		//add the user in database
////		String url2="http://localhost:8080/add_user";
////		HttpEntity<String> request2 = 
////					new HttpEntity<String>(User.toString(), headers);
////
////		String Result2AsJsonStr = 
////					rest.postForObject(url2, request2, String.class);
////        return "added user";
////    }
////	
//	@PostMapping("/users/{question_id}/addcomment")
//	public void add_comment(@PathVariable int question_id,@RequestBody comments Comments) throws JsonProcessingException
//    {
//		System.out.println("yes "+Comments.getName());
//		add_comment a=new add_comment();
//		 a.comment(Comments,question_id);
//		 
//		 
//    }
//	
//	@PostMapping("/users/{parent_id}/{username}/{questionname}/{questiondescription}")
//	public String new_question(@PathVariable int parent_id,@PathVariable String username,@PathVariable String questionname,@PathVariable String questiondescription) throws JsonProcessingException
//    {
//		System.out.println("did you come here");
//		add_question yes=new add_question();
//       return yes.yo(parent_id,username,questionname,questiondescription);
//    }
//	
//    @GetMapping("/users/{parent_id}/allquestions")
//   public List<questions> retrievequestionsinparentforum(@PathVariable int parent_id)
//    {
//	   List<questions> a=new ArrayList<questions>();
//	   System.out.println("you have reached");
//	   subreddit s=  rest.getForObject( "http://localhost:8080/findsubredditbyid/"+parent_id+"", subreddit.class); 
//	   System.out.println(s.getName());
//	   System.out.println(s.question_id_list.get(0));
//       	for(int i=0;i<s.question_id_list.size();i++)
//       	{
//       	  questions q=  rest.getForObject( "http://localhost:8080/findquestionbyid/"+s.question_id_list.get(i)+"", questions.class); 
//       	  a.add(q);
//       	}
//       	return a;
//    }
//   
//   @PostMapping("/users/add_subreddit/{username}/{subredditname}")
//    public void createsubreddit(@PathVariable String username,@PathVariable String subredditname ) throws JsonProcessingException  
//    {
//	   System.out.println(subredditname);
//        add_subreddit t=new add_subreddit();
//        t.yo(username, subredditname);
//        System.out.println("added subreddit");
//    }
//    
//   @PostMapping("users/{question_id}/upvote")
//   public void upvote(@PathVariable int question_id) throws JsonProcessingException
//   {
//	   vote r=new vote();
//	   r.voter(1,question_id);
//   }
//   
//   @PostMapping("users/{question_id}/downvote")
//   public void downvote(@PathVariable int question_id) throws JsonProcessingException
//   {
//	   vote r=new vote();
//	   r.voter(-1,question_id);
//   }
//   
//   @GetMapping("/users/{user_id}")
//   public List<questions> homepage(@PathVariable String user_id)
//   {
//      homepage home =new homepage();
//      return home.a(user_id);
//   }
//  
//   @GetMapping("/authenticate/{username}/{password}")
//  public int executeJwtAuthenticationService(@PathVariable String username, @PathVariable String password) throws JsonProcessingException 
//   {
//	   login a=new login();
//	 
//	   if(  a.yoyo(username, password)==1)
//	   {
//		   return 1; 
//	   }
//     
//       else
//       {
//    	   return 0;
//       }
//   }
//  
//   
//    
//
//	
//
//}




package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.*;
import com.example.demo.auth.login;
import com.example.demo.models.comments;
import com.example.demo.models.questions;
import com.example.demo.models.subreddit;
import com.example.demo.models.user;
import com.example.demo.questions.add_question;
import com.example.demo.questions.vote;
import com.example.demo.subreddit.add_subreddit;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.example.demo.questions.add_comment;

//import com.example.interfaces.Category_interface;
//import com.example.interfaces.Filter_interface;
//
//import com.example.interfaces.Mart_interface;
//import com.example.interfaces.Section_interface;
//import com.example.interfaces.Subcategory_interface;
//import com.example.interfaces.Subfilter_interface;
//import com.example.demo.model.Hell;

@CrossOrigin(origins = "http://localhost:4000")
@RestController
public class restcontroller {
	
	
	RestTemplate rest=new RestTemplate();
	HttpHeaders headers = new HttpHeaders();


    //Hell Hell=new Hell(5);
	
	@GetMapping("/wall")
	public List<questions> retrieveAllQuestions() 
    {
        //console.log('executed service')
		Wall a=new Wall();
        return a.yoyo();
    }
	
//	@PostMapping("/add_user")
//    public String new_user(@RequestBody user User)
//    {
//		
//		//add the user in database
//		String url2="http://localhost:8080/add_user";
//		HttpEntity<String> request2 = 
//					new HttpEntity<String>(User.toString(), headers);
//
//		String Result2AsJsonStr = 
//					rest.postForObject(url2, request2, String.class);
//        return "added user";
//    }
//	
	@PostMapping("/users/{question_id}/addcomment")
	public void add_comment(@PathVariable int question_id,@RequestBody comments Comments) throws JsonProcessingException
    {
		
		add_comment a=new add_comment();
		 a.comment(Comments,question_id);
		 
		 
    }
	
	@PostMapping("/users/{parent_id}/{username}/{questionname}/{questiondescription}")
	public String new_question(@PathVariable int parent_id,@PathVariable String username,@PathVariable String questionname,@PathVariable String questiondescription) throws JsonProcessingException
    {
		
		add_question yes=new add_question();
       return yes.yo(parent_id,username,questionname,questiondescription);
    }
	
    @GetMapping("/users/{parent_id}/allquestions")
   public List<questions> retrievequestionsinparentforum(@PathVariable int parent_id)
    {
	   List<questions> a=new ArrayList<questions>();
	   subreddit s=  rest.getForObject( "http://localhost:8080/findsubredditbyid/"+parent_id+"", subreddit.class); 
	   
       	for(int i=0;i<s.question_id_list.size();i++)
       	{
       	  questions q=  rest.getForObject( "http://localhost:8080/findquestionbyid/"+s.question_id_list.get(i)+"", questions.class); 
       	  a.add(q);
       	}
       	return a;
    }
   
   @PostMapping("/users/add_subreddit/{username}/{subredditname}")
    public int createsubreddit(@PathVariable String username,@PathVariable String subredditname ) throws JsonProcessingException  
    {
	   System.out.println(subredditname);
        add_subreddit t=new add_subreddit();
      return t.yo(username, subredditname);
       
        //System.out.println("added subreddit");
    }
    
   @PostMapping("users/{question_id}/upvote")
   public void upvote(@PathVariable int question_id) throws JsonProcessingException
   {
	   vote r=new vote();
	   r.voter(1,question_id);
   }
   
   @PostMapping("users/{question_id}/downvote")
   public void downvote(@PathVariable int question_id) throws JsonProcessingException
   {
	   vote r=new vote();
	   r.voter(-1,question_id);
   }
   
   @GetMapping("/users/{user_id}")
   public List<questions> homepage(@PathVariable String user_id)
   {
      homepage home =new homepage();
      return home.a(user_id);
   }
  
   @GetMapping("/authenticate/{username}/{password}")
  public int executeJwtAuthenticationService(@PathVariable String username, @PathVariable String password) throws JsonProcessingException 
   {
	   login a=new login();
	 
	   if(  a.yoyo(username, password)==1)
	   {
		   return 1; 
	   }
     
       else
       {
    	   return 0;
       }
   }
  
   
    

	

}


