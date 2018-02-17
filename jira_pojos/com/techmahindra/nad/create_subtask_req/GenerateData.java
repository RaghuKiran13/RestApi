package com.techmahindra.nad.create_subtask_req;

import java.util.ArrayList;
import java.util.List;

import com.techmahindra.nad.generic.GenericLib;


public class GenerateData {
	
	public static CreateSubTask generate(){
		
		Update update=new Update();
		
		Project project =new Project();
		project.setId(GenericLib.getConfigValue("./Jira_Config.properties", "projectId"));
		
		Parent parent =new Parent();
		parent.setId(GenericLib.getConfigValue("./Jira_Config.properties", "storyId"));
		
		
		Issuetype issuetype = new Issuetype();
		issuetype.setId(GenericLib.getConfigValue("./Jira_Config.properties", "subTaskIssue"));
		
		Assignee assignee = new Assignee();
		assignee.setName("sunny.mane");
		
		Priority priority = new Priority();
		priority.setId("3");
		
		Component component = new Component();
		//component.setId("10200");
		
		Timetracking timetracking = new Timetracking();
		timetracking.setOriginalEstimate("5");
		timetracking.setRemainingEstimate("2");
	
		
		Fields fields = new Fields();
		fields.setProject(project);
		fields.setParent(parent);
		fields.setAdditionalProperty("summary", "QA_TEST_SUBTASK3");
		fields.setIssuetype(issuetype);
		fields.setAssignee(assignee);
		fields.setPriority(priority);
		List<String> labels = new ArrayList<>();
		labels.add( "TestDevelopment");
		labels.add(GenericLib.getConfigValue("./Jira_Config.properties", "label"));
		fields.setLabels(labels);
		/*List<Component> components = new ArrayList<>();
		components.add(component);
		fields.setComponents(components);*/
		List<Timetracking>timetrack = new ArrayList<>();
		timetrack.add(timetracking);
		fields.setTimetracking(timetracking);
		fields.setAdditionalProperty("duedate" , "2018-03-11");
		fields.setAdditionalProperty("description", "Summary of the project");
		
		
		CreateSubTask example = new CreateSubTask();
		example.setUpdate(update);
		example.setFields(fields);
		return example;
		
	}
}
