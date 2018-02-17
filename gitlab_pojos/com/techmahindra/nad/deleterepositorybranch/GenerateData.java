package com.techmahindra.nad.deleterepositorybranch;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class GenerateData {
	public static DeleteRepositoryBranch generate() {
		DeleteRepositoryBranch deleteRepositoryBranch=new DeleteRepositoryBranch();
		deleteRepositoryBranch.setProjectId("NAD-1");
		deleteRepositoryBranch.setGitlabProjectId(16);
		deleteRepositoryBranch.setBranch("test-4");
		return deleteRepositoryBranch;
	}
}
