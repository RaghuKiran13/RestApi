package com.techmahindra.nad.create_mr;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class GenerateData {
	public static CreateMR generate() {
		CreateMR createMr=new CreateMR();
		createMr.setProjectId("NAD-1");
		createMr.setGitlabProjectId(16);
		createMr.setMicroserviceKey("MS-1");
		createMr.setSourceBranch("test-4");
		createMr.setTargetBranch("master");
		createMr.setTitle("some title");
		List<String> approvers=new ArrayList<>();
		approvers.add("Some approvers");
		createMr.setApprovers(approvers);
		List<String> approversJiraTickets=new ArrayList<>();
		approversJiraTickets.add("Some approvers jira tickets");
		createMr.setApproversJiraTickets(approversJiraTickets);
		createMr.setDescription("Some description");
		return createMr;
	}
}
