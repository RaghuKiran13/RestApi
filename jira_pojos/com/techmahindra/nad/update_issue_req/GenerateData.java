package com.techmahindra.nad.update_issue_req;

import java.util.ArrayList;
import java.util.List;

import com.techmahindra.nad.generic.GenericLib;

public class GenerateData {
	
	public static UpdateIssue generate(){
		
		
		Set set = new Set();
		set.setName(GenericLib.getConfigValue("./Jira_Config.properties", "assignee"));
		
		
		Assignee assignee = new Assignee();
		assignee.setSet(set);

		Update update = new Update();
		List<Assignee> assigneeList = new ArrayList<>();
		assigneeList.add(assignee);
		update.setAssignee(assigneeList);
		
		UpdateIssue updateIssue = new UpdateIssue();
		updateIssue.setUpdate(update);
		
		return updateIssue;
		
	}

}
