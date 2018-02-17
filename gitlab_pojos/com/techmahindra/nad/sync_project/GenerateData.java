package com.techmahindra.nad.sync_project;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class GenerateData {
	public static SyncProject generate() {
		Authorization_Gitsource authgitsource=new Authorization_Gitsource();
		authgitsource.setApiToken("PLP5dQGmduf9gGajPcJzhdhs");
		authgitsource.setUsername("username");
		authgitsource.setPassword("password");
		
		GitSource gitsource =new GitSource();
		gitsource.setUrl("some url");
		gitsource.setBranch("master");
		gitsource.setAuthorization(authgitsource);
	
		ProjectBranch projectbranch=new ProjectBranch();
		projectbranch.setName("branch name");

		Branch branch =new Branch();
		branch.setName("branch name");
		branch.setRef("branch ref");
		
		Jira jira=new Jira();
		jira.setApprovers("approver 1");
		ProjectMember projectmember=new ProjectMember();
		projectmember.setUserId(1);
		projectmember.setUserType("developer");
		projectmember.setName("john");
		projectmember.setUsername("demo");
		projectmember.setState("active");
		projectmember.setAvatarUrl("avathar url");
		projectmember.setWebUrl("web url");
		projectmember.setAccessLevel(30);
		projectmember.setExpiresAt("31-12-2017");
		
		
		Microservice microservice=new Microservice();
		microservice.setProjectName("Demo");
		microservice.setProjectType("node.js");
		microservice.setRepositoryName("repo");
		microservice.setKey("micro_service_key");
		microservice.setGitSource(gitsource);
		microservice.setDescription("This project is created using API");
		List<ProjectBranch> projectBranches = new ArrayList<>();
		projectBranches.add(projectbranch);
		microservice.setProjectBranches(projectBranches);
		List<ProjectMember> projectMembers= new ArrayList<>();
		projectMembers.add(projectmember);
		microservice.setProjectMembers(projectMembers);
		microservice.setJira(jira);
		
		Authorization_Gitlocation authgitlocation=new Authorization_Gitlocation();
		authgitlocation.setApiToken("PLP5dQGmduf9gGajPcJzhdhs");
		authgitlocation.setUsername("uname");
		authgitlocation.setPassword("pwd");
		GitLocation gitLocation=new GitLocation();
		gitLocation.setUrl("git location url");
		gitLocation.setAuthorization(authgitlocation);
		
		SyncProject syncproject=new SyncProject();
		syncproject.setProjectId("NAD-1");
		syncproject.setProjectDescription("NAD-project-name");
		syncproject.setProjectName("NAD-project-description");
		List<Microservice> microservices=new ArrayList<>();
		microservices.add(microservice);
		syncproject.setMicroservices(microservices);
		
		syncproject.setGitLocation(gitLocation);
		return syncproject;
		
		
	}
}
