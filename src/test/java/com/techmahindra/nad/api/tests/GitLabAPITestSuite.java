package com.techmahindra.nad.api.tests;

import java.io.IOException;
import java.util.HashMap;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.testng.annotations.Test;

import com.techmahindra.nad.addmemberfromproject.AddMemberFromProject_Marshalling;
import com.techmahindra.nad.api.factory.BaseApiLib;
import com.techmahindra.nad.editmemberfromproject.EditMemberFromProject_Marshalling;
import com.techmahindra.nad.generic.GenericLib;

import io.restassured.response.Response;

public class GitLabAPITestSuite extends BaseApiLib{
	String[] testData=null;
	String[] urlData=null;
	String[] authData=null;
	String[] paramKey=null;
	Integer[] statusCodes=null;

	/***************************************************************
	 *  Gitlab - Get list of all projects.
	 ***************************************************************/
	@Test(testName = "List all projects Test", description = "List all projects", priority = 1, enabled = true)
	public void listAllProjects(){
		authData=GenericLib.excelData_String(GenericLib.gitLabTestDataPath+"//gitlab_project.xlsx","generic","Authorization");
		urlData=GenericLib.excelData_String(GenericLib.gitLabTestDataPath+"//gitlab_project.xlsx","url","List all projects");
		testData=GenericLib.excelData_String(GenericLib.gitLabTestDataPath+"//gitlab_project.xlsx","list all projects","tc_01");
		paramKey=GenericLib.excelData_String(GenericLib.gitLabTestDataPath+"//gitlab_project.xlsx","list all projects","tc_id");
		statusCodes=GenericLib.excelData_Integer(GenericLib.gitLabTestDataPath+"//gitlab_project.xlsx","generic","Exp_status code");

		HashMap<String, String> headers = new HashMap<String, String>();

		headers.put(authData[0],authData[1]);

		HashMap<String, Integer> queryParams= new HashMap<String, Integer>();

		queryParams.put(paramKey[1], Integer.parseInt(testData[1]));
		queryParams.put(paramKey[2], Integer.parseInt(testData[2]));

		Response response=	getRequest_QueryParam(headers, queryParams, urlData[1]);
		verifyStatus(response,statusCodes[1]);
	}
	/***************************************************************
	 *  Gitlab - Get list of group project members.
	 ***************************************************************/
	@Test(testName = "List all members of a projects Test", description = "Get list of project members", priority = 2, enabled = true)
	public void listAllMembersOfProjects(){

		authData=GenericLib.excelData_String(GenericLib.gitLabTestDataPath+"//gitlab_projectmember.xlsx","generic","Authorization");
		urlData=GenericLib.excelData_String(GenericLib.gitLabTestDataPath+"//gitlab_projectmember.xlsx","url","List all members of a project");
		testData=GenericLib.excelData_String(GenericLib.gitLabTestDataPath+"//gitlab_projectmember.xlsx","list all members of a project","tc_01");
		paramKey=GenericLib.excelData_String(GenericLib.gitLabTestDataPath+"//gitlab_projectmember.xlsx","list all members of a project","tc_id");
		statusCodes=GenericLib.excelData_Integer(GenericLib.gitLabTestDataPath+"//gitlab_projectmember.xlsx","generic","Exp_status code");

		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put(authData[0],authData[1]);
		int gitLabId=Integer.parseInt(GenericLib.getConfigValue("./Gitlab_Config.properties", "gitLabId"));

		HashMap<String, Integer> pathparam = new HashMap<String, Integer>();
		pathparam.put(paramKey[1], Integer.parseInt(testData[1]));
		Response response = getRequest_param(headers,pathparam,urlData[1]);
		verifyStatus(response, statusCodes[1]);
	}
	/***************************************************************
	 *  Gitlab - List Users

	 ***************************************************************/
	@Test(testName = "list users Test", description = "list users", priority = 3, enabled = true)
	public void listUsers() throws JsonGenerationException, JsonMappingException, IOException{
		authData=GenericLib.excelData_String(GenericLib.gitLabTestDataPath+"//gitlab_user.xlsx","generic","Authorization");
		urlData=GenericLib.excelData_String(GenericLib.gitLabTestDataPath+"//gitlab_user.xlsx","url","List Users");
		testData=GenericLib.excelData_String(GenericLib.gitLabTestDataPath+"//gitlab_user.xlsx","list users","tc_01");
		paramKey=GenericLib.excelData_String(GenericLib.gitLabTestDataPath+"//gitlab_user.xlsx","list users","tc_id");
		statusCodes=GenericLib.excelData_Integer(GenericLib.gitLabTestDataPath+"//gitlab_user.xlsx","generic","Exp_status code");

		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put(authData[0],authData[1]);

		HashMap<String, Integer> queryParams= new HashMap<String, Integer>();
		queryParams.put(paramKey[1], Integer.parseInt(testData[1]));
		queryParams.put(paramKey[2], Integer.parseInt(testData[2]));

		Response response=	getRequest_QueryParam(headers, queryParams,urlData[1]);
		verifyStatus(response,statusCodes[1]);
		System.out.println(response.asString());
	}
	/***************************************************************
	 *  Gitlab - List Merge Request
	 ***************************************************************/
	@Test(testName = "list Merge Request Test", description = "list Merge Request", priority = 4, enabled = true)
	public void listMergeRequest(){
		authData=GenericLib.excelData_String(GenericLib.gitLabTestDataPath+"//gitlab_mergerequest.xlsx","generic","Authorization");
		urlData=GenericLib.excelData_String(GenericLib.gitLabTestDataPath+"//gitlab_mergerequest.xlsx","url","List merge requests");
		testData=GenericLib.excelData_String(GenericLib.gitLabTestDataPath+"//gitlab_mergerequest.xlsx","list merge requests","tc_01");
		paramKey=GenericLib.excelData_String(GenericLib.gitLabTestDataPath+"//gitlab_mergerequest.xlsx","list merge requests","tc_id");
		statusCodes=GenericLib.excelData_Integer(GenericLib.gitLabTestDataPath+"//gitlab_mergerequest.xlsx","generic","Exp_status code");

		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put(authData[0],authData[1]);
		
		HashMap<String, Integer> pathparams = new HashMap<String, Integer>();
		pathparams.put(paramKey[1], Integer.parseInt(testData[1]));

		Response response=	getRequest_param(headers, pathparams,urlData[1]);
		verifyStatus(response,statusCodes[1]);
		//System.out.println(response.asString());
	}

	/***************************************************************
	 *  Gitlab - List Repository Branches
	 ***************************************************************/
	@Test(testName = "list Repository Test", description = "Get Repository Branches list", priority = 5, enabled = true)
	public void listRepositoryBranches() {
		
		authData=GenericLib.excelData_String(GenericLib.gitLabTestDataPath+"//gitlab_branch.xlsx","generic","Authorization");
		urlData=GenericLib.excelData_String(GenericLib.gitLabTestDataPath+"//gitlab_branch.xlsx","url","List repository branches");
		testData=GenericLib.excelData_String(GenericLib.gitLabTestDataPath+"//gitlab_branch.xlsx","list repository branches","tc_01");
		paramKey=GenericLib.excelData_String(GenericLib.gitLabTestDataPath+"//gitlab_branch.xlsx","list repository branches","tc_id");
		statusCodes=GenericLib.excelData_Integer(GenericLib.gitLabTestDataPath+"//gitlab_branch.xlsx","generic","Exp_status code");
		
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put(authData[0],authData[1]);

		HashMap<String, Integer> pathParams= new HashMap<String, Integer>();
		
		pathParams.put(paramKey[1], Integer.parseInt(testData[1]));
		pathParams.put(paramKey[2], Integer.parseInt(testData[2]));

		Response response=	getRequest_param(headers, pathParams,urlData[1]);
		verifyStatus(response,statusCodes[1]);
		System.out.println(response.asString());
	}
	/***************************************************************
	 *  Gitlab - Get validation
	 ***************************************************************/
	@Test(testName = "validation Test", description = "Validation", priority = 6, enabled = true)
	public void validation(){
		
		authData=GenericLib.excelData_String(GenericLib.gitLabTestDataPath+"//gitlab_validation.xlsx","generic","Authorization");
		urlData=GenericLib.excelData_String(GenericLib.gitLabTestDataPath+"//gitlab_validation.xlsx","url","Validation");
		testData=GenericLib.excelData_String(GenericLib.gitLabTestDataPath+"//gitlab_validation.xlsx","validation","tc_01");
		paramKey=GenericLib.excelData_String(GenericLib.gitLabTestDataPath+"//gitlab_validation.xlsx","validation","tc_id");
		statusCodes=GenericLib.excelData_Integer(GenericLib.gitLabTestDataPath+"//gitlab_validation.xlsx","generic","Exp_status code");
		
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put(authData[0],authData[1]);

		HashMap<String, Integer> queryParams= new HashMap<String, Integer>();
		queryParams.put(paramKey[1], Integer.parseInt(testData[1]));
		queryParams.put(paramKey[2], Integer.parseInt(testData[2]));

		Response response=	getRequest_QueryParam(headers, queryParams, urlData[1]);
		verifyStatus(response,statusCodes[1]);
	}
	/***************************************************************
	 *  Gitlab - Add Member to project
	 ***************************************************************/
	@Test(testName = "Add Member to project Test", description = "Add Member to the project", priority = 7, enabled = true)
	public void addMemberToProject() throws JsonGenerationException, JsonMappingException, IOException{
		authData=GenericLib.excelData_String(GenericLib.gitLabTestDataPath+"//gitlab_projectmember.xlsx","generic","Authorization");
		statusCodes=GenericLib.excelData_Integer(GenericLib.gitLabTestDataPath+"//gitlab_projectmember.xlsx","generic","Exp_status code");
		urlData=GenericLib.excelData_String(GenericLib.gitLabTestDataPath+"//gitlab_projectmember.xlsx","url","Add member to a project");
				
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put(authData[0],authData[1]);
		Object object = AddMemberFromProject_Marshalling.createJson();
		Response response=	postRequest(headers, object, urlData[1]);
		verifyStatus(response,statusCodes[1]);
	}
	/***************************************************************
	 *  Gitlab - Edit Member to project
	 ***************************************************************/
	@Test(testName = "Edit Member to project Test", description = "Edit Member to project", priority = 8, enabled = true)
	public void editMemberToProject() throws JsonGenerationException, JsonMappingException, IOException{
		
		authData=GenericLib.excelData_String(GenericLib.gitLabTestDataPath+"//gitlab_projectmember.xlsx","generic","Authorization");
		statusCodes=GenericLib.excelData_Integer(GenericLib.gitLabTestDataPath+"//gitlab_projectmember.xlsx","generic","Exp_status code");
		urlData=GenericLib.excelData_String(GenericLib.gitLabTestDataPath+"//gitlab_projectmember.xlsx","url","Edit a member of project");
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put(authData[0],authData[1]);
		Object object = EditMemberFromProject_Marshalling.createJson();

		Response response=	postRequest(headers, object,urlData[1]);
		verifyStatus(response,statusCodes[1]);

		getObjectValue(response, "expires_at", "expires_at");
	}

	
	
	/***************************************************************
	 * 3. Gitlab – Get the Branch created 
	 ***************************************************************/

	@Test(testName = "List Branch Test", description = "Listing a repository branch using Gitlab API", priority = 3, enabled = false)
	public void listBranch() throws JsonGenerationException, JsonMappingException, IOException {

		// Setting authorization configuration
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Authorization", GenericLib.getConfigValue("./Gitlab_Config.properties", "authorization"));

		// Get Branch Details Service
		Response response = getRequest_contentType(headers,
				GenericLib.getConfigValue("./Gitlab_Config.properties", "branchURL"));

		// Verifying Status Code
		verifyStatus(response, Integer.parseInt(GenericLib.getConfigValue("./Gitlab_Config.properties", "statusCode")));

		// Verify Is success
		verifyResponse_boolean(response, true, "is_success", "'is_success'");

	} // End of List Branch Test
}
