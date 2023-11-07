package com.example.demo.models;

import java.util.ArrayList;

public class user {

	 private String password;
	 private String id;
	 private String user_type;
	 private String email_id;
	 public ArrayList<Integer> subreddit_id_list;
	 public ArrayList<Integer> question_id_list;
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getUser_type() {
		return user_type;
	}
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	public String getUsername() {
		return id;
	}
	public void setUsername(String username) {
		this.id = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	 
}
