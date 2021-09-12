# jira-log-tracker
Jira log tracker for the efficient way of checking latest updates of any project and tracking the updates of jira

#### Environment
* Java 8 
* Maven > 3.0
* Spring Boot 2.5.4

###### Rest APIs
1.
```
GET /Summary
Request Param: jiraId 
```
JiraId of the Jira for which you want to fetch the Summary

2.
```
GET /logs
```
Returns Jira issue details about the Jira Items which are get filtered with provided JQL in application.properties file

#### Future work Items
* Add/Modify API to accept JQL from user and Provide the needed details fot those Jira Issues
* Provide ability to sort the result according to the created/updated date
* Add DockerFile to the current repo
* Add Api Doc json 
