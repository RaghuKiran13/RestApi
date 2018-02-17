package com.techmahindra.nad.create_project;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class GenerateData {
	public static CreateProject generate() {
		CreateProject createProject=new CreateProject();
		createProject.setProjectId("NAD-1");
		createProject.setApiToken("PLP5dQGmduf9gGajPcJzhdhs");
		createProject.setUserId(1);
		createProject.setName("project name");
		createProject.setPath("repo path");
		createProject.setDefaultBranch("master");
		createProject.setNamespaceId(0);
		createProject.setDescription("some description");
		createProject.setIssuesEnabled(true);
		createProject.setMergeRequestsEnabled(true);
		createProject.setJobsEnabled(true);
		createProject.setWikiEnabled(true);
		createProject.setSnippetsEnabled(true);
		createProject.setResolveOutdatedDiffDiscussions(true);
		createProject.setContainerRegistryEnabled(true);
		createProject.setSharedRunnersEnabled(true);
		createProject.setVisibility("some visibility");
		createProject.setImportUrl("some url");
		createProject.setPublicJobs(true);
		createProject.setOnlyAllowMergeIfPipelineSucceeds(true);
		createProject.setOnlyAllowMergeIfAllDiscussionsAreResolved(true);
		createProject.setLfsEnabled(true);
		createProject.setRequestAccessEnabled(true);
		List<String> tagList=new ArrayList<>();
		tagList.add("some tag name");
		createProject.setTagList(tagList);
		createProject.setPrintingMergeRequestLinkEnabled(0);
		createProject.setCiConfigPath("some config path");
		createProject.setRepositoryStorage("Some storage");
		createProject.setApprovalsBeforeMerge(0);
		
		return createProject;
		
		
	}
}
