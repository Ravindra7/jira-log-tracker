package com.ravindra.jiralog.model;

import java.util.List;

public class IssueDetail {
	private String key;
	private String summary;
	private List<CommentDetail> comments;
	
	public IssueDetail(String key, String summary, List<CommentDetail> comments) {
		super();
		this.key = key;
		this.summary = summary;
		this.comments = comments;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public List<CommentDetail> getComments() {
		return comments;
	}

	public void setComments(List<CommentDetail> comments) {
		this.comments = comments;
	}
	
	

	
}
