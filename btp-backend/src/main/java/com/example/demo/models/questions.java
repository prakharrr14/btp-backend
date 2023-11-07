package com.example.demo.models;

import java.util.ArrayList;

public class questions {
	
	private int id;
	private int votes;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getVotes() {
		return votes;
	}
	public void setVotes(int votes) {
		this.votes = votes;
	}

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	public String getSubreddit_name() {
		return subreddit_name;
	}
	public void setSubreddit_name(String subreddit_name) {
		this.subreddit_name = subreddit_name;
	}

	public String getSubreddit_url() {
		return subreddit_url;
	}
	public void setSubreddit_url(String subreddit_url) {
		this.subreddit_url = subreddit_url;
	}

	public String getQuestion_description() {
		return question_description;
	}
	public void setQuestion_description(String question_description) {
		this.question_description = question_description;
	}

	private String name;
	private String url;
	private String subreddit_name;
	private String subreddit_url;
	private String question_description;
	 public ArrayList<comments> comments_list;
	 
	

}
