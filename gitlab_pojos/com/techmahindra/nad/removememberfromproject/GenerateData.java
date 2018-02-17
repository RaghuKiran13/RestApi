package com.techmahindra.nad.removememberfromproject;

public class GenerateData {
	public static RemoveMemberFromProject generate() {
		RemoveMemberFromProject removeMemberFromProject=new RemoveMemberFromProject();
		removeMemberFromProject.setProjectId("NAD-1");
		removeMemberFromProject.setGitlabProjectId(16);
		removeMemberFromProject.setUserId(10);
		return removeMemberFromProject;
	}
}
