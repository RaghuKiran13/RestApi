package com.techmahindra.nad.api.tests;

import java.io.IOException;
import java.util.HashMap;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.testng.annotations.Test;

import com.techmahindra.nad.api.factory.BaseApiLib;
import com.techmahindra.nad.generic.GenericLib;

import io.restassured.response.Response;

public class JenkinsAPITestSuite extends BaseApiLib {


	/**********************************************
	 1. Jenkins – Get Job History with Jenkins api
	 **********************************************/

	@Test(testName = "Get Jenkins Job History Test", description = "Get Jenkins job history using Jenkins API", priority = 1, enabled = true)
	public void getJenkinsJobHistory()
			throws InterruptedException, JsonGenerationException, JsonMappingException, IOException {
	//	Thread.sleep(20000);

		// Setting authorization configuration
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Authorization", GenericLib.getConfigValue("./Jenkins_Config.properties", "authorization"));

		String url = GenericLib.getConfigValue("./Jenkins_Config.properties", "JenkinsURL")
				+ GenericLib.getConfigValue("./API_Config.properties", "key") + "/history/api/json";

		// Get Jenkins Job History Service
		Response response = getRequest_contentType(headers, url);
		System.out.println(response.asString());
		System.out.println(response.statusCode());
		
		// Verify statuscode
		//verifyStatus(response, Integer.parseInt(GenericLib.getConfigValue("./Jenkins_Config.properties", "statusCode")));

			// Verify Message
		verifyResponse(response, GenericLib.getConfigValue("./Jira_Config.properties", "changeStatusCode"),
								"statusCode", "Change Issue Status Code");

		// Verify Is success
		verifyResponse_boolean(response, true, "is_success", "'is_success'");

	} // End of Get Jenkins Job History Test

}
