package com.techmahindra.nad.pushrepositorybranch;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class GenerateData {
	public static PushRepositoryBranch generate() {

		PushRepositoryBranch pushRepositoryBranch=new PushRepositoryBranch();
		pushRepositoryBranch.setId(16);
		pushRepositoryBranch.setBranch("master");
		pushRepositoryBranch.setCommitMessage("Some commit message");
		pushRepositoryBranch.setStartBranch("master");
		List<Action> actions=new ArrayList<>();

		Action action=new Action();
		action.setAction("create");
		action.setFilePath("some file path ");
		action.setContent("Some content");
		action.setPreviousPath("someprevious path");
		actions.add(action);
		pushRepositoryBranch.setActions(actions);
		return pushRepositoryBranch;
	}
}
