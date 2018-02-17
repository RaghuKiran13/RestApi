package com.techmahindra.nad.approve_mr;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class GenerateData {
	public static ApproveMR generate() {
		
		ApproveMR approveMr=new ApproveMR();
		approveMr.setProjectId(16);
		approveMr.setMergeRequestId(10);
		return approveMr;
	}
}
