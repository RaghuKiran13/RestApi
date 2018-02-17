package com.techmahindra.nad.create_issue_req;

import java.util.ArrayList;
import java.util.List;

import com.techmahindra.nad.generic.GenericLib;

public class GenerateData {

	public static CreateIssue generate() {

		Update update = new Update();

		Project project = new Project();
		project.setId(GenericLib.getConfigValue("./Jira_Config.properties", "projectId"));

		Issuetype issueType = new Issuetype();
		issueType.setId(GenericLib.getConfigValue("./Jira_Config.properties", "storyIssue"));

		Assignee assignee = new Assignee();
		assignee.setName("sunny.mane");

		Priority priority = new Priority();
		priority.setId("3");

		Timetracking timetracking = new Timetracking();
		timetracking.setOriginalEstimate("5");
		timetracking.setRemainingEstimate("2");

		Fields fields = new Fields();
		fields.setPriority(priority);
		fields.setProject(project);
		fields.setAdditionalProperty("summary", "QA_TEST_STORY3");
		fields.setIssuetype(issueType);
		fields.setAssignee(assignee);
		
		List<String> labels = new ArrayList<>();
		labels.add("label_1");
		fields.setLabels(labels);
		fields.setTimetracking(timetracking);
		fields.setAdditionalProperty("duedate", "2018-03-11");
		fields.setAdditionalProperty("description", "Summary of the project");
		fields.setAdditionalProperty("customfield_10000", "TES-230");           // Config Epic value from properties

		CreateIssue createIssue = new CreateIssue();
		createIssue.setUpdate(update);
		createIssue.setFields(fields);
		return createIssue;

	}

}
