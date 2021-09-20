package com.ravindra.jiralog.model;

import javax.annotation.Nullable;

import org.joda.time.DateTime;

import com.atlassian.jira.rest.client.api.domain.BasicUser;
import com.atlassian.jira.rest.client.api.domain.Visibility;

public class CommentDetail implements Comparable<CommentDetail> {

	@Nullable
	private String author;
	private String creationDate;
	private DateTime updateDate;
	private String body;

	public CommentDetail(String author, String creationDate, DateTime updateDate, String body) {
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
		return updateDate.toString();
	}

	public void setUpdateDate(DateTime updateDate) {
		this.updateDate = updateDate;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public int compareTo(CommentDetail o) {
		return o.updateDate.compareTo(this.updateDate);
	}

}
