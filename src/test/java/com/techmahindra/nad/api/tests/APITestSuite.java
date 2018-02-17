package com.techmahindra.nad.api.tests;

import java.io.IOException;
import java.util.HashMap;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.testng.annotations.Test;

import com.techmahindra.nad.api.factory.BaseApiLib;
import com.techmahindra.nad.create_issue_req.CreateIssue_Marshaling;
import com.techmahindra.nad.create_subtask_req.CreateSubTask_Marshaling;
import com.techmahindra.nad.generic.GenericLib;
import com.techmahindra.nad.issue_change_status_req.IssueChangeStatus_Marshaling;

import io.restassured.response.Response;

public class APITestSuite extends BaseApiLib {

	/***************************************************************
	 * 1. Jira - Get the Project Information with the Jira Project Key a. Call
	 * Jira API – Get Project Information b. Get the Project ID from the
	 * response
	 ***************************************************************/

	@Test(testName = "Get ProjectInfo Test", description = "Get the Project Information with the Jira Project Key", priority = 1, enabled = false)
	public void getProjectInfo() {

		// Setting authorization configuration
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Authorization", GenericLib.getConfigValue("./API_Config.properties", "Jira_Authorization"));

		// Send Get Project Info Service
//		Response response = getRequest_param(headers,
//				GenericLib.getConfigValue("./API_Config.properties", "ProjectInfo"),
//				GenericLib.getConfigValue("./API_Config.properties", "ProjectId"),
//				GenericLib.getConfigValue("./API_Config.properties", "JiraProjectURL"));

		// Verify status code
	//	verifyStatus(response, 200);

		// Verify Project id
		//verifyResponse(response, 10100, "id", "Project Id");

	}// End of Get ProjectInfo Test

	/************************************************************
	 * 2. Jira - Create Issue- creating a story first a. Call Jira API to create
	 * a issue b. Verify the issue is created
	 ************************************************************/

	@Test(testName = "CreateIssue Test", description = "Create Issue- creating a story first using Jira API", priority = 2, enabled = true)
	public void createIssue() throws JsonGenerationException, JsonMappingException, IOException {

		// Setting authorization configuration
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Authorization", GenericLib.getConfigValue("./API_Config.properties", "Jira_Authorization"));

		// Conversion of POJO to Json Object
		Object object = CreateIssue_Marshaling.createJson();

		// Post Create story Service
		Response response = postRequest(headers, object,
				GenericLib.getConfigValue("./API_Config.properties", "JireIssueURL"));

		// Verify statuscode
		verifyStatus(response, 200);

		String idValue = getObjectValue(response, "id", "Issue id");

		// Writing value into config.properties file
		GenericLib.setConfigValue("./API_Config.properties", "issue_id", idValue);

	}// End of Create Issue Test

	/***************************************************************
	 * 3. Create Issue – Create Sub Task Under the Story Created a. Call Gitlab
	 * API – List Repository Branches b. Verify the Sub Task Branch is created
	 ***************************************************************/

	@Test(testName = "Create SubTask Test", description = "Create Issue – Create Sub Task Under the Story Created using Jira API", priority = 3, enabled = false)
	public void createSubTask() throws JsonGenerationException, JsonMappingException, IOException {

		// Setting authorization configuration
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Authorization", GenericLib.getConfigValue("./API_Config.properties", "Jira_Authorization"));

		// Conversion of POJO to Json Object
		Object object = CreateSubTask_Marshaling.createJson();

		// Post Sub Task Service
		Response response = postRequest(headers, object,
				GenericLib.getConfigValue("./API_Config.properties", "JireIssueURL"));

		// Verifying Status Code
		verifyStatus(response, 200);

		String key_value = getObjectValue(response, "key", "Project key");
		// Writing value into config.properties file
		GenericLib.setConfigValue("./API_Config.properties", "key", key_value);

	} // End of Create SubTask Test

	/***************************************************************
	 * 4. JIRA – Change the status of created Issue a. Call Jira API to change
	 * the status of Issue b. Verify the Status is created
	 ***************************************************************/

	@Test(testName = "ChangeIssueStatus Test", description = "Change the status of created Issue using Jira API", priority = 4, enabled = false)
	public void changeIssueStatus() throws JsonGenerationException, JsonMappingException, IOException {

		// Setting authorization configuration
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Authorization", GenericLib.getConfigValue("./API_Config.properties", "Jira_Authorization"));

		// Conversion of POJO to Json Object
		Object object = IssueChangeStatus_Marshaling.createJson();

		String url = GenericLib.getConfigValue("./API_Config.properties", "JireIssueURL") + "/"
				+ GenericLib.getConfigValue("./API_Config.properties", "key") + "/transitions/transition.fields";
		// Post Change the status Service
		Response response = postRequest(headers, object, url);

		// Verifying Status Code
		verifyStatus(response, 200);

		verifyResponse_Int(response, 204,"statusCode",  "Issue_Status Code");
	} // End of ChangeIssueStatus Test

	/***************************************************************
	 * 5. Gitlab – Get the Branch created a. Call Gitlab API – List Repository
	 * Branches b. Verify the Branch with Issue Name is created
	 ***************************************************************/

	@Test(testName = "List Branch Test", description = "Listing a repository branch using Gitlab API", priority = 5, enabled = false)
	public void listBranch() throws JsonGenerationException, JsonMappingException, IOException {

		// Setting authorization configuration
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Authorization", GenericLib.getConfigValue("./API_Config.properties", "Gitlab_Authorization"));

		// Get Branch Details Service
		Response response = getRequest_contentType(headers,
				GenericLib.getConfigValue("./API_Config.properties", "GitlabURL"));

		// Verifying Status Code
		verifyStatus(response, 200);

		verifyResponse_boolean(response,true, "is_success",  "'is_success' Code");
	} // End of List Branch Test

	/***************************************************************
	 * 6. Jenkins – Get Job History a. Call Jenkins API - Jenkins job history b.
	 * Verify Jenkins job with Issue name is created
	 ***************************************************************/

	@Test(testName = "Get Jenkins Job History Test", description = "Get Jenkins job history using Jenkins API", priority = 6, enabled = false)
	public void getJenkinsJobHistory()
			throws InterruptedException, JsonGenerationException, JsonMappingException, IOException {
		Thread.sleep(20000);

		// Setting authorization configuration
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Authorization", GenericLib.getConfigValue("./API_Config.properties", "Jenkins_Authorization"));

		String url = GenericLib.getConfigValue("./API_Config.properties", "JenkinsURL")
				+ GenericLib.getConfigValue("./API_Config.properties", "key") + "/history/api/json";
		// Get Jenkins Job History Service
		Response response = getRequest_contentType(headers, url);

		// Verifying Status Code
		verifyStatus(response, 200);

		verifyResponse_boolean(response, true, "is_success", "'is_success'");

	} // End of Get Jenkins Job History Test

	/*
	 * @Test(testName = "Get ProjectInfo Test", description =
	 * "Get the Project Information with Invalid url and Invalid Authorization Key"
	 * , priority = 7, enabled =false) public void getProjectInfo_Invalid() {
	 * 
	 * // Setting authorization configuration HashMap<String, String> headers =
	 * new HashMap<String, String>(); headers.put("Authorization",
	 * GenericLib.getConfigValue("./API_Config.properties",
	 * "Jira_Authorization")+"//Basic"); // Send Get Project Info Service
	 * Response response = getRequest_param(headers,
	 * GenericLib.getConfigValue("./API_Config.properties", "ProjectInfo"),
	 * GenericLib.getConfigValue("./API_Config.properties", "ProjectId"),
	 * GenericLib.getConfigValue("./API_Config.properties",
	 * "JiraProjectURL")+"//Basic");
	 * 
	 * // Verify status code verifyStatus(response);
	 * 
	 * // Verify Project id verifyResponse(response, "id", 10100, "Project Id");
	 * 
	 * }// End of Get ProjectInfo Test
	 */
}
