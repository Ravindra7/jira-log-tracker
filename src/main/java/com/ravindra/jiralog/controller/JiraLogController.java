package com.ravindra.jiralog.controller;

import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ravindra.jiralog.model.IssueDetail;
import com.ravindra.jiralog.service.JiraLogFetcher;

@RestController
public class JiraLogController {

	@Autowired
	JiraLogFetcher jiralogfetcher;

	@GetMapping("/summary")
	public ResponseEntity<String> getSummary(@RequestParam(value = "jiraId", required = false) String jiraid) {

		if (StringUtils.isEmpty(jiraid)) {
			return new ResponseEntity<String>("Jira ID not provied", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>(jiralogfetcher.getJiraIssueSummary(jiraid), HttpStatus.OK);
	}

	@RequestMapping(value = "logs", method = RequestMethod.GET, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<IssueDetail>> getlogs(
			@RequestParam(value = "name", defaultValue = "World") String name) {
		return new ResponseEntity<List<IssueDetail>>(jiralogfetcher.getJiraLogs(), HttpStatus.OK);
	}
}
