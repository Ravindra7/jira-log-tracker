package com.ravindra.jiralog.service;

import java.util.List;

import com.ravindra.jiralog.model.IssueDetail;

public interface JiraLogFetcher {

	List<IssueDetail> getJiraLogs(int fromDays);

	String getJiraIssueSummary(String jiraId);

}
