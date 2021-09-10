package com.ravindra.jiralog.model;

import javax.annotation.Nullable;

import org.joda.time.DateTime;

import com.atlassian.jira.rest.client.api.domain.BasicUser;
import com.atlassian.jira.rest.client.api.domain.Visibility;

public class CommentDetail {

	@Nullable
	private String author;
	private String creationDate;
	private String updateDate;
	private String body;

	public CommentDetail(String author, String creationDate, String updateDate, String body) {
		super();
		this.author = author;
		this.creationDate = creationDate;
		this.updateDate = updateDate;
		this.body = body;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

}
