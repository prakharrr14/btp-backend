package com.example.demo.models;

import java.util.ArrayList;

public class subreddit {
	
	private int id;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<String> getUsers_list() {
		return users_list;
	}
	public void setUsers_list(ArrayList<String> users_list) {
		this.users_list = users_list;
	}
	public ArrayList<String> getTags_list() {
		return tags_list;
	}
	public void setTags_list(ArrayList<String> tags_list) {
		this.tags_list = tags_list;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String name;
	private String url;
	 public ArrayList<String> users_list;
	 public ArrayList<String> tags_list;
	 public  ArrayList<Integer> question_id_list;

}

