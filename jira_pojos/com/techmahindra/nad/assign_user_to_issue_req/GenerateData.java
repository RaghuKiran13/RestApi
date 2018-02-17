package com.techmahindra.nad.assign_user_to_issue_req;

import com.techmahindra.nad.generic.GenericLib;

public class GenerateData {
	
	public static AssignUserToIssue generate(){
		
		AssignUserToIssue assignUserToIssue = new AssignUserToIssue();
		assignUserToIssue.setName(GenericLib.getConfigValue("./Jira_Config.properties", "assignee"));
		return assignUserToIssue;
		
	}

}
