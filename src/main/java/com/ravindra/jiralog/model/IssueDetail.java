package com.ravindra.jiralog.model;

import java.util.Set;

public class IssueDetail {
	private String key;
	private String summary;
	private Set<CommentDetail> comments;
	
	public IssueDetail(String key, String summary, Set<CommentDetail> comments) {
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

	public Set<CommentDetail> getComments() {
		return comments;
	}

	public void setComments(Set<CommentDetail> comments) {
		this.comments = comments;
	}
	
	

	
}
