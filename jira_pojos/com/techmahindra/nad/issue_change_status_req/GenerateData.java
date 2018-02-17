package com.techmahindra.nad.issue_change_status_req;

public class GenerateData {
	
	public static IssueChangeStatus generate(){
		
		Transition transition = new Transition();
		transition.setId("21");
		
		IssueChangeStatus issueChangeStatus = new IssueChangeStatus();
		issueChangeStatus.setTransition(transition);
		return issueChangeStatus;
	}

}
