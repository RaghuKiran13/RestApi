package com.techmahindra.nad.create_custome_issue_req;

public class GenerateData {
	
	public static CreateCustomeIssue generate(){
		
		CreateCustomeIssue createCustomIssue = new CreateCustomeIssue();
		createCustomIssue.setProjectId("");
		createCustomIssue.setSummary("");
		createCustomIssue.setIssueType("");
		createCustomIssue.setAssignee("");
		createCustomIssue.setDescription("");
		
		return createCustomIssue;
	}

}
