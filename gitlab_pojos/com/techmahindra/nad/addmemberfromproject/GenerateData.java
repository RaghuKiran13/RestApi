package com.techmahindra.nad.addmemberfromproject;

public class GenerateData {
	public static AddMemberFromProject generate() {
		
		AddMemberFromProject addMemberFromProject=new AddMemberFromProject();
		addMemberFromProject.setProjectId("NAD-1");
		addMemberFromProject.setGitlabProjectId(16);
		addMemberFromProject.setUserId(10);
		addMemberFromProject.setAccessLevel(30);
		addMemberFromProject.setExpiresAt("2017-12-31");
		return addMemberFromProject;
	}
}
