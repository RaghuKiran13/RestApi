package com.techmahindra.nad.editmemberfromproject;

import com.techmahindra.nad.generic.GenericLib;

public class GenerateData {
	public static EditMemberFromProject generate() {
		EditMemberFromProject editMemberFromProject=new EditMemberFromProject();
		editMemberFromProject.setProjectId("NAD-1");
		editMemberFromProject.setGitlabProjectId(16);
		editMemberFromProject.setUserId(10);
		editMemberFromProject.setAccessLevel(30);
		editMemberFromProject.setExpiresAt(GenericLib.getConfigValue("./Gitlab_Config.properties", "memberData"));
		return editMemberFromProject;
	}
}