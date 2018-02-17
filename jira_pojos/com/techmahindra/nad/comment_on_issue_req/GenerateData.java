package com.techmahindra.nad.comment_on_issue_req;

import com.techmahindra.nad.generic.GenericLib;

public class GenerateData {
	
	public static CommentOnIssue generate(){
		
		CommentOnIssue commentOnIssue = new CommentOnIssue();
		commentOnIssue.setBody(GenericLib.getConfigValue("./Jira_Config.properties", "comment"));
		
		return commentOnIssue;
	}

}
