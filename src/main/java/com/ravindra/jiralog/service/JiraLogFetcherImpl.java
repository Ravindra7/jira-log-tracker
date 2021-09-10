package com.ravindra.jiralog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ravindra.jiralog.client.CustomJiraClient;
import com.ravindra.jiralog.model.IssueDetail;

@Component
public class JiraLogFetcherImpl implements JiraLogFetcher {

	@Autowired
	CustomJiraClient customJiraClient;

	@Override
	public String getJiraIssueSummary(String jiraId) {
		return customJiraClient.getIssueSummary(jiraId);

	}

	@Override
	public List<IssueDetail> getJiraLogs() {
		return customJiraClient.getIssueLogs();
	}

}
