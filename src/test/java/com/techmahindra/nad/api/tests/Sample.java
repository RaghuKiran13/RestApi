package com.techmahindra.nad.api.tests;

import org.testng.annotations.Test;

import com.techmahindra.nad.generic.GenericLib;

public class Sample {
	String[] testData=null;
	String[] urlData=null;
	String[] genericData=null;
	@Test
	public void sampleTest(){
		genericData=GenericLib.excelData_String(GenericLib.gitLabTestDataPath+"//gitlab_user.xlsx","generic","Authorization");
		Integer[] numericData = GenericLib.excelData_Integer(GenericLib.gitLabTestDataPath+"//gitlab_user.xlsx","generic","Exp_status code");
//		urlData=GenericLib.excelData_String(GenericLib.gitLabTestDataPath+"//gitlab_user.xlsx","url","List Users");
//		testData=GenericLib.excelData_String(GenericLib.gitLabTestDataPath+"//gitlab_user.xlsx","list users","tc_01");
//		System.out.println(genericData.length);
//		System.out.println(urlData.length);
//		System.out.println(testData.length);
		
//		System.out.println("*******");
//		System.out.println(genericData[0]);3
//		System.out.println(urlData[0]);
//		System.out.println(testData[0]);
//		System.out.println("********/*/*/*/*/*");
		
		System.out.println(numericData.length);
		System.out.println(numericData[0]);
		
		for (Integer string : numericData) {
			System.out.println(string);
		}
		
//		for (String string : genericData) {
//			System.out.println(string);
//		}
//		for (String string : urlData) {
//			System.out.println(string);
//		}
//		for (String string : testData) {
//			System.out.println(string);
//		}
	}
}
