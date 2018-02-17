package com.techmahindra.nad.add_worklog_to_issue_req;

public class GenerateData {
	
	public static AddWorklogToIssue generate(){
		
		AddWorklogToIssue addWorklogToIssue = new AddWorklogToIssue();
		addWorklogToIssue.setComment("");
		addWorklogToIssue.setStarted("");
		addWorklogToIssue.setTimeSpentSeconds(0);
		return addWorklogToIssue;
	}

}
