package com.techmahindra.nad.create_new_project_req;

public class GenerateData {
	
	public static CreateNewProject generate(){
		
		CreateNewProject createNewProject = new CreateNewProject();
		createNewProject.setProjectId("");
		createNewProject.setKey("");
		createNewProject.setName("");
		createNewProject.setProjectTypeKey("");
		createNewProject.setDescription("");
		createNewProject.setLead("");
		createNewProject.setUrl("");
		createNewProject.setAvatarId(1);
		
		
		return createNewProject;
	}

}
