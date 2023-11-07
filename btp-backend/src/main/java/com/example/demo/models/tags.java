package com.example.demo.models;

import java.util.ArrayList;

public class tags {

	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<String> getSubreddits_list() {
		return subreddits_list;
	}
	public void setSubreddits_list(ArrayList<String> subreddits_list) {
		this.subreddits_list = subreddits_list;
	}
	private String name;
	private ArrayList<String> subreddits_list;
}
