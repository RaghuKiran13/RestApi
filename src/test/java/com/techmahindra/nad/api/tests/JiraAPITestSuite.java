package com.techmahindra.nad.api.tests;

import java.io.IOException;
import java.util.HashMap;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.testng.annotations.Test;

import com.techmahindra.nad.api.factory.BaseApiLib;
import com.techmahindra.nad.assign_user_to_issue_req.AssignUserToIssue_Marshaling;
import com.techmahindra.nad.comment_on_issue_req.CommentOnIssue_Marshaling;
import com.techmahindra.nad.create_issue_req.CreateIssue_Marshaling;
import com.techmahindra.nad.create_new_project_req.CreateNewProject_Marshaling;
import com.techmahindra.nad.create_subtask_req.CreateSubTask_Marshaling;
import com.techmahindra.nad.generic.GenericLib;
import com.techmahindra.nad.issue_change_status_req.IssueChangeStatus_Marshaling;
import com.techmahindra.nad.update_issue_req.UpdateIssue_Marshaling;

import io.restassured.response.Response;

public class JiraAPITestSuite extends BaseApiLib {

	/***************************************************************
	 * 1. Jira - Create Issue - create a stories with the epic key
	 ***************************************************************/

	@Test(testName = "Create Issue Test", description = "Create Issue- creating a story first using Jira API", priority = 1, enabled = true)
	public void createIssue() throws JsonGenerationException, JsonMappingException, IOException {

		// Setting authorization configuration
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Authorization", GenericLib.getConfigValue("./Jira_Config.properties", "authorization"));

		// Conversion of POJO to Json Object
		Object object = CreateIssue_Marshaling.createJson();

		// Post Create story Service
		Response response = postRequest(headers, object,
				GenericLib.getConfigValue("./Jira_Config.properties", "issueURL"));

		// Verify statuscode
		verifyStatus(response, Integer.parseInt(GenericLib.getConfigValue("./Jira_Config.properties", "statusCode")));

		// Writing value into config.properties file
		String idValue = getObjectValue(response, "id", "storyId");
		GenericLib.setConfigValue("./Jira_Config.properties", "storyId", idValue);
		String key_value = getObjectValue(response, "key", "storyKey");
		GenericLib.setConfigValue("./Jira_Config.properties", "storyKey", key_value);

	}// End of Create Issue Test

	/***************************************************************
	 * 2. Create Issue – Create Sub Task Under the Story Created
	 ***************************************************************/

	@Test(testName = "Create SubTask Test", description = "Create Issue – Create Sub Task Under the Story Created using Jira API", priority = 2, enabled = true)
	public void createSubTask() throws JsonGenerationException, JsonMappingException, IOException {

		// Setting authorization configuration
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Authorization", GenericLib.getConfigValue("./Jira_Config.properties", "authorization"));

		// Conversion of POJO to Json Object
		Object object = CreateSubTask_Marshaling.createJson();

		// Post Sub Task Service
		Response response = postRequest(headers, object,
				GenericLib.getConfigValue("./Jira_Config.properties", "issueURL"));

		// Verify statuscode
		verifyStatus(response, Integer.parseInt(GenericLib.getConfigValue("./Jira_Config.properties", "statusCode")));

		// Writing value into config.properties file
		String idValue = getObjectValue(response, "id", "subTaskId");
		GenericLib.setConfigValue("./Jira_Config.properties", "subTaskId", idValue);
		String key_value = getObjectValue(response, "key", "subTaskKey");
		GenericLib.setConfigValue("./Jira_Config.properties", "subTaskKey", key_value);

	} // End of Create SubTask Test

	/***************************************************************
	 * 3. JIRA – Change the status of created Issue
	 ***************************************************************/

	@Test(testName = "ChangeIssueStatus Test", description = "Change the status of created Issue using Jira API", priority = 3, enabled = true)
	public void changeIssueStatus() throws JsonGenerationException, JsonMappingException, IOException {

		// Setting authorization configuration
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Authorization", GenericLib.getConfigValue("./Jira_Config.properties", "authorization"));

		// Conversion of POJO to Json Object
		Object object = IssueChangeStatus_Marshaling.createJson();

		String url = GenericLib.getConfigValue("./Jira_Config.properties", "issueURL") + "/"
				+ GenericLib.getConfigValue("./Jira_Config.properties", "subTaskKey")
				+ "/transitions/transition.fields";

		// Post Change the status Service
		Response response = postRequest(headers, object, url);

		// Verify statuscode
		verifyStatus(response,
				Integer.parseInt(GenericLib.getConfigValue("./Jira_Config.properties", "changeStatusCode")));

	} // End of ChangeIssueStatus Test

	/***************************************************************
	 * 4. Jira - Validate Configuration with the Jira Project Key
	 ***************************************************************/

	@Test(testName = "Validate Configuration Test", description = "Validation of Configuration", priority = 4, enabled = true)
	public void validateConfig() {

		// Send Get Project Info Service
		Response response = getRequest(GenericLib.getConfigValue("./Jira_Config.properties", "validateConfigURL"));

		// Verify status code
		verifyStatus(response, Integer.parseInt(GenericLib.getConfigValue("./Jira_Config.properties", "statusCode")));

		// Verify Message
		verifyResponse(response, GenericLib.getConfigValue("./Jira_Config.properties", "validateConfigValidation"),
				"message", "Message");

	}

	/*********************************************************
	 * 5. Jira - Get all issue types for the issue available
	 * 
	 **********************************************************/

	@Test(testName = "Get All Issuetypes Test", description = "Get all issue types for the issue available ", priority = 5, enabled = true)
	public void getAllIssueTypes() {

		// Setting authorization configuration
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Authorization", GenericLib.getConfigValue("./Jira_Config.properties", "authorization"));

		// Send Get Project Info Service
		Response response = getRequest_contentType(headers,
				GenericLib.getConfigValue("./Jira_Config.properties", "issueTypeURL"));

		// Verify status code
		verifyStatus(response, Integer.parseInt(GenericLib.getConfigValue("./Jira_Config.properties", "statusCode")));

		// Verify Message
		verifyResponse(response, GenericLib.getConfigValue("./Jira_Config.properties", "successMsg"), "message",
				"Message");
	}

	/***************************************************************
	 * 6. Jira - Get all Project List
	 ***************************************************************/

	@Test(testName = "Get All Project List Test", description = "Get all project list information", priority = 6, enabled = true)
	public void getAllProjectList() {

		// Setting authorization configuration
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Authorization", GenericLib.getConfigValue("./Jira_Config.properties", "authorization"));

		// Send Get Project Info Service
		Response response = getRequest_contentType(headers,
				GenericLib.getConfigValue("./Jira_Config.properties", "projectURL"));

		// Verify status code
		verifyStatus(response, Integer.parseInt(GenericLib.getConfigValue("./Jira_Config.properties", "statusCode")));

		// Verify Message
		verifyResponse(response, GenericLib.getConfigValue("./Jira_Config.properties", "successMsg"), "message",
				"Message");
	}

	/***************************************************************
	 * 7. Jira - Create New Project
	 ***************************************************************/

	@Test(testName = "Create New Project Test", description = "Creation of New Project", priority = 7, enabled = true)
	public void createNewProject() throws JsonGenerationException, JsonMappingException, IOException {

		// Setting authorization configuration
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Authorization", GenericLib.getConfigValue("./Jira_Config.properties", "authorization"));

		// Conversion of POJO to Json Object
		Object object = CreateNewProject_Marshaling.createJson();

		// Send Get Project Info Service
		Response response = getRequest_contentType(headers,
				GenericLib.getConfigValue("./Jira_Config.properties", "projectURL"));

		// Verify status code
		verifyStatus(response, Integer.parseInt(GenericLib.getConfigValue("./Jira_Config.properties", "statusCode")));

		/*
		 * // Verify Message verifyResponse(response,
		 * GenericLib.getConfigValue("./Jira_Config.properties", "successMsg"),
		 * "message", "Message");
		 */
	}

	/***************************************************************
	 * 8. Jira - Get all Project Boards with the Jira Project Key
	 ***************************************************************/

	@Test(testName = "Get All Project Boards Test", description = "Get all Project Boards information", priority = 8, enabled = true)
	public void getAllProjectBoards() {

		// Setting authorization configuration
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Authorization", GenericLib.getConfigValue("./Jira_Config.properties", "authorization"));

		// Send Get Project Info Service
		Response response = getRequest_contentType(headers,
				GenericLib.getConfigValue("./Jira_Config.properties", "projectURL"));

		// Verify status code
		verifyStatus(response, Integer.parseInt(GenericLib.getConfigValue("./Jira_Config.properties", "statusCode")));

		/*
		 * // Verify Message verifyResponse(response,
		 * GenericLib.getConfigValue("./Jira_Config.properties", "successMsg"),
		 * "message", "Message");
		 */
	}

	/***************************************************************
	 * 9. Jira - Get all possible transitions for the issue
	 ***************************************************************/

	@Test(testName = "Get all possible transitions for the issue Test", description = "Get all possible transitions information for the issue", priority = 9, enabled = true)
	public void getAllPossibleIssueTransitions() {

		// Setting authorization configuration
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Authorization", GenericLib.getConfigValue("./Jira_Config.properties", "authorization"));

		String url = GenericLib.getConfigValue("./Jira_Config.properties", "issueURL") + "/"
				+ GenericLib.getConfigValue("./Jira_Config.properties", "subTaskId") + "/transitions/transition.fields";

		// Send Get Project Info Service
		Response response = getRequest_contentType(headers, url);

		// Verify status code
		verifyStatus(response, Integer.parseInt(GenericLib.getConfigValue("./Jira_Config.properties", "statusCode")));

	}

	/***************************************************************
	 * 10. Jira - Get all issues for the project through Agile
	 ***************************************************************/

	@Test(testName = "Get all issues for the project through Agile Test", description = "Get all issues for the project information through Agile", priority = 10, enabled = true)
	public void getAllIssuesForTheProj() {

		// Setting authorization configuration
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Authorization", GenericLib.getConfigValue("./Jira_Config.properties", "authorization"));

		String url = GenericLib.getConfigValue("./Jira_Config.properties", "issueURL") + "/list/"
				+ GenericLib.getConfigValue("./Jira_Config.properties", "projectKey");

		// Send Get Project Info Service
		Response response = getRequest_contentType(headers, url);

		// Verify status code
		verifyStatus(response, Integer.parseInt(GenericLib.getConfigValue("./Jira_Config.properties", "statusCode")));

		// Verify Message
		verifyResponse(response, GenericLib.getConfigValue("./Jira_Config.properties", "successMsg"), "message",
				"Message");
	}

	/***************************************************************
	 * 11. Jira - Update Issue
	 ***************************************************************/

	@Test(testName = "Update Issue Test", description = "Updating Issue", priority = 11, enabled = true)
	public void updateIssue() throws JsonGenerationException, JsonMappingException, IOException {

		// Setting authorization configuration
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Authorization", GenericLib.getConfigValue("./Jira_Config.properties", "authorization"));

		// Conversion of POJO to Json Object
		Object object = UpdateIssue_Marshaling.createJson();

		String url = GenericLib.getConfigValue("./Jira_Config.properties", "issueURL") + "/"
				+ GenericLib.getConfigValue("./Jira_Config.properties", "subTaskId");

		// Post Sub Task Service
		Response response = putRequest(headers, object, url);

		// Verify status code
		verifyStatus(response,
				Integer.parseInt(GenericLib.getConfigValue("./Jira_Config.properties", "changeStatusCode")));

	}

	/***************************************************************
	 * 12. Jira - Get Issue Information
	 ***************************************************************/

	@Test(testName = "Get Issue Information Test", description = "Get Issue Information", priority = 12, enabled = true)
	public void getIssueInfo() {

		// Setting authorization configuration
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Authorization", GenericLib.getConfigValue("./Jira_Config.properties", "authorization"));

		String url = GenericLib.getConfigValue("./Jira_Config.properties", "issueURL") + "/"
				+ GenericLib.getConfigValue("./Jira_Config.properties", "subTaskId");

		// Send Get Project Info Service
		Response response = getRequest_contentType(headers, url);

		// Verify status code
		verifyStatus(response, Integer.parseInt(GenericLib.getConfigValue("./Jira_Config.properties", "statusCode")));

	}

	/***************************************************************
	 * 13. Jira - Get User Information
	 ***************************************************************/

	@Test(testName = "Get User Information Test", description = "Get User Information", priority = 13, enabled = true)
	public void getUserInfo() {

		// Setting authorization configuration
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Authorization", GenericLib.getConfigValue("./Jira_Config.properties", "authorization"));

		String url = GenericLib.getConfigValue("./Jira_Config.properties", "userURL") + "/"
				+ GenericLib.getConfigValue("./Jira_Config.properties", "assignee");

		// Send Get Project Info Service
		Response response = getRequest_contentType(headers, url);

		// Verify status code
		verifyStatus(response, Integer.parseInt(GenericLib.getConfigValue("./Jira_Config.properties", "statusCode")));

		// Verify Message
		verifyResponse(response, GenericLib.getConfigValue("./Jira_Config.properties", "displayName"), "displayName",
				"displayName");
		verifyResponse(response, GenericLib.getConfigValue("./Jira_Config.properties", "assignee"), "name", "Name");
	}

	/***************************************************************
	 * 14. Jira - Get User List
	 ***************************************************************/

	@Test(testName = "Get User List Test", description = "Get User List", priority = 14, enabled = true)
	public void getUserList() {

		// Setting authorization configuration
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Authorization", GenericLib.getConfigValue("./Jira_Config.properties", "authorization"));

		String url = GenericLib.getConfigValue("./Jira_Config.properties", "userURL") + "/project/"
				+ GenericLib.getConfigValue("./Jira_Config.properties", "projectKey");

		// Send Get Project Info Service
		Response response = getRequest_contentType(headers, url);

		// Verify status code
		verifyStatus(response, Integer.parseInt(GenericLib.getConfigValue("./Jira_Config.properties", "statusCode")));

		// Verify Message
		verifyResponse(response, GenericLib.getConfigValue("./Jira_Config.properties", "successMsg"), "message",
				"Message");

	}

	/***************************************************************
	 * 15. Jira - Get User List
	 ***************************************************************/

	@Test(testName = "Get User Test", description = "Get User List", priority = 15, enabled = true)
	public void getAllCommentsOfIssue() {

		// Setting authorization configuration
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Authorization", GenericLib.getConfigValue("./Jira_Config.properties", "authorization"));

		HashMap<String, String> pathParam = new HashMap<String, String>();

		pathParam.put("issue_id", GenericLib.getConfigValue("./Jira_Config.properties", "subTaskId"));
		pathParam.put("start_at", "1");
		pathParam.put("max_results", "45");
		pathParam.put("order_by", "column");

		// Send Get Project Info Service
		Response response = getRequest(headers, pathParam,
				GenericLib.getConfigValue("./Jira_Config.properties", "issueURL")
						+ "/{issue_id}/comment/{start_at}/{max_results}/{order_by}");

		// Verify status code
		verifyStatus(response, Integer.parseInt(GenericLib.getConfigValue("./Jira_Config.properties", "statusCode")));

	}

	/***************************************************************
	 * 16. Jira - Assign User to Issue
	 ***************************************************************/

	@Test(testName = "Assign User to Issue Test", description = "Assign User to Issue", priority = 16, enabled = true)
	public void assignUserToIssue() throws JsonGenerationException, JsonMappingException, IOException {

		// Setting authorization configuration
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Authorization", GenericLib.getConfigValue("./Jira_Config.properties", "authorization"));

		// Conversion of POJO to Json Object
		Object object = AssignUserToIssue_Marshaling.createJson();

		String url = GenericLib.getConfigValue("./Jira_Config.properties", "issueURL") + "/"
				+ GenericLib.getConfigValue("./Jira_Config.properties", "subTaskId") + "/assignee";

		// Post Sub Task Service
		Response response = putRequest(headers, object, url);

		// Verify status code
		verifyStatus(response,
				Integer.parseInt(GenericLib.getConfigValue("./Jira_Config.properties", "changeStatusCode")));

	}

	/***************************************************************
	 * 17. Jira - Comment on Issue
	 ***************************************************************/

	@Test(testName = "Comment on Issue Test", description = "Comment on Issue", priority = 17, enabled = true)
	public void commentOnIssue() throws JsonGenerationException, JsonMappingException, IOException {

		// Setting authorization configuration
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Authorization", GenericLib.getConfigValue("./Jira_Config.properties", "authorization"));

		// Conversion of POJO to Json Object
		Object object = CommentOnIssue_Marshaling.createJson();

		String url = GenericLib.getConfigValue("./Jira_Config.properties", "issueURL") + "/"
				+ GenericLib.getConfigValue("./Jira_Config.properties", "subTaskId") + "/comment";

		// Post Sub Task Service
		Response response = postRequest(headers, object, url);

		// Verify status code
		verifyStatus(response, Integer.parseInt(GenericLib.getConfigValue("./Jira_Config.properties", "statusCode")));

		// Verify Comments
		verifyResponse(response, GenericLib.getConfigValue("./Jira_Config.properties", "comment"), "body", "Comments");

	}

	/***************************************************************
	 * 18. Jira - Get All Possible Transitions of Issue
	 ***************************************************************/

	@Test(testName = "Get All Possible Transitions of IssueTest", description = "Get All Possible Transitions of Issue", priority = 18, enabled = true)
	public void getAllPossibleTransitionsOfIssue() {

		// Setting authorization configuration
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Authorization", GenericLib.getConfigValue("./Jira_Config.properties", "authorization"));

		HashMap<String, String> pathParam = new HashMap<String, String>();

		pathParam.put("issue_id", GenericLib.getConfigValue("./Jira_Config.properties", "subTaskId"));
		pathParam.put("expand", "testing");

		// Send Get Project Info Service
		Response response = getRequest(headers, pathParam,
				GenericLib.getConfigValue("./Jira_Config.properties", "issueURL") + "/{issue_id}/transitions/{expand}");

		// Verify status code
		verifyStatus(response, Integer.parseInt(GenericLib.getConfigValue("./Jira_Config.properties", "statusCode")));

	}

	/***************************************************************
	 * 19. Jira - Get All Worklogs for the Issue
	 ***************************************************************/

	@Test(testName = "Get All Worklogs for the Issue Test", description = "Get All Worklogs for the Issue", priority = 19, enabled = true)
	public void getAllWorkLogsForTheIssue() {

		// Setting authorization configuration
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Authorization", GenericLib.getConfigValue("./Jira_Config.properties", "authorization"));

		HashMap<String, String> pathParam = new HashMap<String, String>();

		pathParam.put("issue_id", GenericLib.getConfigValue("./Jira_Config.properties", "subTaskId"));

		// Send Get Project Info Service
		Response response = getRequest(headers, pathParam,
				GenericLib.getConfigValue("./Jira_Config.properties", "issueURL") + "/{issue_id}/worklog");

		// Verify status code
		verifyStatus(response, Integer.parseInt(GenericLib.getConfigValue("./Jira_Config.properties", "statusCode")));

	}

	/***************************************************************
	 * 20. Jira - Get Editable Issue Meta Data
	 ***************************************************************/

	@Test(testName = "Get Editable Issue Meta Data Test", description = "Get Editable Issue Meta Data", priority = 20, enabled = true)
	public void getEditableIssueMetaData() {

		// Setting authorization configuration
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Authorization", GenericLib.getConfigValue("./Jira_Config.properties", "authorization"));

		HashMap<String, String> pathParam = new HashMap<String, String>();

		pathParam.put("issue_id", GenericLib.getConfigValue("./Jira_Config.properties", "subTaskId"));

		// Send Get Project Info Service
		Response response = getRequest(headers, pathParam,
				GenericLib.getConfigValue("./Jira_Config.properties", "issueURL") + "/{issue_id}/editmeta");

		// Verify status code
		verifyStatus(response, Integer.parseInt(GenericLib.getConfigValue("./Jira_Config.properties", "statusCode")));

	}

}
