package com.techmahindra.nad.update_mr;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class GenerateData {
	public static UpdateMR generate() {

		UpdateMR updateMr=new UpdateMR();
		updateMr.setId(16);
		updateMr.setTargetBranch("staging");
		updateMr.setTitle("master");
		updateMr.setAssigneeId(10);
		updateMr.setDescription("some description ");
		updateMr.setStateEvent("Some state event");
		updateMr.setLabels("some labels");
		updateMr.setMilestoneId(0);
		updateMr.setRemoveSourceBranch(true);
		updateMr.setMergeRequestIid(3);
		updateMr.setSquash(true);
		updateMr.setDiscussionLocked(true);

		return updateMr;


	}
}
