package com.techmahindra.nad.accept_mr;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class GenerateData {
	public static AcceptMR generate() {

		AcceptMR acceptMr=new AcceptMR();
		acceptMr.setId(16);
		acceptMr.setMergeRequestIid(10);
		acceptMr.setMergeCommitMessage("some message");
		acceptMr.setShouldRemoveSourceBranch(true);
		acceptMr.setMergeWhenPipelineSucceeds(true);
		acceptMr.setSha("Some sha value");

		return acceptMr;
	}
}
