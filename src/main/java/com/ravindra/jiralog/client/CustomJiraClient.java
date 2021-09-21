package com.ravindra.jiralog.client;

import java.net.URI;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import javax.annotation.PostConstruct;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.api.domain.Issue;
import com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClientFactory;
import com.ravindra.jiralog.model.CommentDetail;
import com.ravindra.jiralog.model.IssueDetail;

@Component
public class CustomJiraClient {

	@Value("${jira.username}")
	private String username;

	@Value("${jira.password}")
	private String password;

	@Value("${jira.baseUrl}")
	private String jiraUrl;

	@Value("${jira.searchJqlText}")
	private String searchJqlText;

	private JiraRestClient jiraRestClient;

	@PostConstruct
	public void postConstruct() {
		jiraRestClient = getJiraRestClient();
	}

	private JiraRestClient getJiraRestClient() {
		return new AsynchronousJiraRestClientFactory().createWithBasicHttpAuthentication(getJiraUri(), username,
				password);
	}

	private URI getJiraUri() {
		return URI.create(this.jiraUrl);
	}

	public String getIssueSummary(String jiraId) {
		return jiraRestClient.getIssueClient().getIssue(jiraId).claim().getSummary();
	}

	public List<IssueDetail> getIssueLogs(int fromDays) {

		Iterable<Issue> issues = jiraRestClient.getSearchClient().searchJql(searchJqlText).claim().getIssues();

		List<IssueDetail> issueDetails = new ArrayList<>();

		issues.forEach(issue -> {
			TreeSet<CommentDetail> commentDetail = new TreeSet<>();

			jiraRestClient.getIssueClient().getIssue(issue.getKey()).claim().getComments().forEach(comment -> {
				DateTime yesterday = DateTime.now().minusDays(fromDays);
				boolean isFromThoseManyDays = comment.getUpdateDate().isAfter(yesterday);
				if (isFromThoseManyDays) {
					commentDetail.add(new CommentDetail(comment.getAuthor().getDisplayName(),
							comment.getCreationDate().toString(), comment.getUpdateDate(),
							comment.getBody().toString()));
				}

			});
			issueDetails.add(new IssueDetail(issue.getKey(), issue.getSummary(), commentDetail));

		});
		return issueDetails;
	}

}
