package com.techmahindra.nad.createrepositorybranch;

public class GenerateData {
	public static CreateRepositoryBranch generate() {
		CreateRepositoryBranch createRepositoryBranch =new CreateRepositoryBranch();
		createRepositoryBranch.setProjectId("NAD-1");
		createRepositoryBranch.setGitlabProjectId(16);
		createRepositoryBranch.setBranch("test-4");
		createRepositoryBranch.setRefBranch("master"); 
		return createRepositoryBranch;
	}
}
