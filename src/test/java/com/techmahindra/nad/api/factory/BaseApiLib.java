package com.techmahindra.nad.api.factory;

import static io.restassured.RestAssured.given;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.testng.Assert;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class BaseApiLib {
	/*
	 * To Verify Response Status Code
	 */
	public static void verifyStatus(Response rsp, int expStatusCode) {
		try {
			Assert.assertEquals(rsp.statusCode(), expStatusCode, "Status code are not equal");

			NXGReports.addStep("Validation of Status Code", String.valueOf(expStatusCode), String.valueOf(rsp.getStatusCode()),
					LogAs.PASSED, null);
		} catch (AssertionError e) {
			NXGReports.addStep("Validation of Status Code", String.valueOf(expStatusCode),
					String.valueOf(rsp.getStatusCode()), LogAs.FAILED, null);
			throw e;
		}
	}
	
	/*
	 * To send Get Request with query parameters
	 */
public static Response getRequest_param(HashMap<String, String> headers,HashMap<String, Integer> pathParam,
			String url) {

		StringBuilder builder = new StringBuilder();
		for (Map.Entry map : headers.entrySet()) {
			builder.append(String.valueOf(map.getKey())).append(" : ").append(String.valueOf(map.getValue())).append("\n");
		}
		
		for (Map.Entry map : pathParam.entrySet()) {
			builder.append(String.valueOf(map.getKey())).append(" : ").append(String.valueOf(map.getValue())).append("\n");
		}
		builder.append("url").append(" : ").append(url);
		NXGReports.addStep("Input values", builder.toString(), LogAs.INFO, null);

		Response response = given().
				headers(headers).
				pathParameters(pathParam).
				when().
				get(url);

		NXGReports.addStep("GET request is sent", LogAs.INFO, null);
		String resp = formatString(response.asString(), 50);
		NXGReports.addStep("Response", " ", resp, LogAs.INFO, null);
		return response;
	}

	public static Response getRequest(HashMap<String, String> headers,HashMap<String, String> pathParam,
			String url) {

		StringBuilder builder = new StringBuilder();
		for (Map.Entry map : headers.entrySet()) {
			builder.append(String.valueOf(map.getKey())).append(" : ").append(String.valueOf(map.getValue())).append("\n");
		}
		
		for (Map.Entry map : pathParam.entrySet()) {
			builder.append(String.valueOf(map.getKey())).append(" : ").append(String.valueOf(map.getValue())).append("\n");
		}
		builder.append("url").append(" : ").append(url);
		NXGReports.addStep("Input values", builder.toString(), LogAs.INFO, null);

		Response response = given().
				headers(headers).
				pathParameters(pathParam).
				when().
				get(url);

		NXGReports.addStep("GET request is sent", LogAs.INFO, null);
		String resp = formatString(response.asString(), 50);
		NXGReports.addStep("Response", " ", resp, LogAs.INFO, null);
		return response;
	}

	/*
	 * To send Get Request without parametres
	 */
	public static Response getRequest(String url) {

		NXGReports.addStep("Input values", url , LogAs.INFO, null);

		Response response = given().
				when().
				get(url);
		NXGReports.addStep("GET request is sent", LogAs.INFO, null);
		String resp = formatString(response.asString(), 50);
		NXGReports.addStep("Response", " ", resp, LogAs.INFO, null);
		return response;
	}

	/*
	 * To send Get Request with parametres
	 */
	public static Response getRequest_QueryParam(HashMap<String, String> headers,HashMap<String, Integer> queryParams,String url) {

		StringBuilder builder = new StringBuilder();
		for (Map.Entry map : headers.entrySet()) {
			builder.append(String.valueOf(map.getKey())).append(" : ").append(String.valueOf(map.getValue())).append("\n");
		}
		for (Map.Entry map : queryParams.entrySet()) {
			builder.append(String.valueOf(map.getKey())).append(" : ").append(String.valueOf(map.getValue())).append("\n");
		}
		builder.append("url").append(" : ").append(url);
		NXGReports.addStep("Input values", builder.toString(), LogAs.INFO, null);

		Response response=given().
				headers(headers).
				queryParams(queryParams).
				when().
				get(url);

		NXGReports.addStep("GET request is sent", LogAs.INFO, null);
		String resp = formatString(response.asString(), 50);
		NXGReports.addStep("Response", " ", resp, LogAs.INFO, null);
		return response;
	}

	/*
	 * To send Get Request with ContentType
	 */
	public static Response getRequest_contentType(HashMap<String, String> headers, String url) {
		StringBuilder builder = new StringBuilder();
		for (Map.Entry map : headers.entrySet()) {
			builder.append(String.valueOf(map.getKey())).append(" : ").append(String.valueOf(map.getValue())).append("\n");
		}
		builder.append("url").append(" : ").append(url);
		NXGReports.addStep("Inputs",builder.toString(),LogAs.INFO, null);


		Response response = given().
				headers(headers).
				contentType("application/json").
				when().
				get(url);

		NXGReports.addStep("GET request is sent", LogAs.INFO, null);
		String resp = formatString(response.asString(), 50);
		NXGReports.addStep("Response", " ", resp, LogAs.INFO, null);
		return response;
	}
	
	/*
	 * To PUT request
	 */
	
	public static Response putRequest(HashMap<String, String> headers, Object object, String url)
			throws JsonGenerationException, JsonMappingException, IOException {

		StringBuilder builder =new StringBuilder();
		for (Map.Entry map : headers.entrySet()) {
			builder.append(String.valueOf(map.getKey())).append(" :").append(String.valueOf(map.getValue())).append("\n");
		}
		builder.append("url").append(" : ").append(url).append("\n").append("Request : ").append("\n").append(formatString(object.toString(), 50));
		NXGReports.addStep("Inputs", builder.toString(), LogAs.INFO, null);


		Response response = given().
				headers(headers).
				body(object).
				contentType("application/json").
				when().
				put(url);


		NXGReports.addStep("Post Request Sent", LogAs.INFO, null);
		String resp = formatString(response.asString(), 50);
		NXGReports.addStep("Response", " ", resp, LogAs.INFO, null);
		return response;
	}

	/*
	 * To POST request
	 */
	public static Response postRequest(HashMap<String, String> headers, Object object, String url)
			throws JsonGenerationException, JsonMappingException, IOException {

		StringBuilder builder =new StringBuilder();
		for (Map.Entry map : headers.entrySet()) {
			builder.append(String.valueOf(map.getKey())).append(" :").append(String.valueOf(map.getValue())).append("\n");
		}
		builder.append("url").append(" : ").append(url).append("\n").append("Request : ").append("\n").append(formatString(object.toString(), 50));
		NXGReports.addStep("Inputs", builder.toString(), LogAs.INFO, null);


		Response response = given().
				headers(headers).
				body(object).
				contentType("application/json").
				when().
				post(url);


		NXGReports.addStep("Post Request Sent", LogAs.INFO, null);
		String resp = formatString(response.asString(), 50);
		NXGReports.addStep("Response", " ", resp, LogAs.INFO, null);
		return response;
	}


	/*
	 * To split the string based on number of characters
	 */
	public static String formatString(String str, int chunkSize) {

		// String str = response.asString();
		int arraySize = (int) Math.ceil((double) str.length() / chunkSize);

		String[] returnArray = new String[arraySize];

		int index = 0;
		for (int i = 0; i < str.length(); i = i + chunkSize) {
			if (str.length() - i < chunkSize) {
				returnArray[index++] = str.substring(i);
			} else {
				returnArray[index++] = str.substring(i, i + chunkSize);
			}
		}

		StringBuilder finalStr = new StringBuilder();
		finalStr.append("\n");
		int finalChar = 0;
		for (int i = 0; i < returnArray.length; i++) {
			finalStr.append(returnArray[i]);
			finalStr.append("\n");
			finalChar = finalChar + returnArray[i].length();
		}

		Assert.assertEquals(finalChar, str.length());
		return finalStr.toString();
	}


	//Verify Response
	public static void verifyResponse(Response response,String expOjbectValue, String actualOjbectValue, String description ){
		JsonPath jpath = new JsonPath(response.asString());
		try {
			Assert.assertEquals(expOjbectValue, jpath.get(actualOjbectValue).toString(),  description + " didnt mathced..");
			NXGReports.addStep(description + " Validation", expOjbectValue, jpath.get(actualOjbectValue).toString(), LogAs.PASSED, null);
		} catch (AssertionError e) {
			NXGReports.addStep(description + " Validation", expOjbectValue, jpath.get(actualOjbectValue).toString(), LogAs.FAILED, null);
			throw e;
		}

	}

	/*
	 * Parsing the Json Response and verifying with actual and expected values
	 */
	public static void verifyResponse(Response response, int id, String objectName, String description) {
		JsonPath jpath = new JsonPath(response.asString());
		String project_id = jpath.get(objectName);

		try {
			Assert.assertEquals(Integer.parseInt(project_id), id, description + " didnt mathced..");
			NXGReports.addStep(description + " is matching", project_id,String.valueOf(id),  LogAs.PASSED, null);
		} catch (AssertionError e) {
			NXGReports.addStep(description + " is not matching", project_id, String.valueOf(id), LogAs.FAILED, null);
			throw e;
		}
	}

	/*
	 * Parsing the Json Response and verifying with actual and expected values
	 */
	public static void verifyResponse_Int(Response response,  int id,String objectName, String description) {
		JsonPath jpath = new JsonPath(response.asString());
		int project_id = jpath.get(objectName);

		try {
			Assert.assertEquals(project_id, id, description + " didnt mathced..");
			NXGReports.addStep(description + " is matching",String.valueOf(project_id), String.valueOf(id), 
					LogAs.PASSED, null);
		} catch (AssertionError e) {
			NXGReports.addStep(description + " is not matching",  String.valueOf(project_id),String.valueOf(id),
					LogAs.FAILED, null);
			throw e;
		}
	}

	/*
	 * 
	 */
	public static void verifyResponse_boolean(Response response,boolean value,  String objectName, String description) {
		JsonPath jpath = new JsonPath(response.asString());
		boolean is_success_value = jpath.get(objectName);

		try {
			Assert.assertEquals(is_success_value, value, description + " didnt mathced..");
			NXGReports.addStep(description + " Validation", String.valueOf(value), String.valueOf(is_success_value),
					LogAs.PASSED, null);
		} catch (AssertionError e) {
			NXGReports.addStep(description + " Validation", String.valueOf(value),String.valueOf(is_success_value),
					LogAs.FAILED, null);
			throw e;
		}
	}

	/*
	 * Parsing the Json Response
	 */
	public static String getObjectValue(Response resp, String objectName, String description) {
		JsonPath jpath = new JsonPath(resp.asString());
		String objectValue = jpath.get(objectName);
		NXGReports.addStep(description, " ", objectValue, LogAs.INFO, null);
		return objectValue;
	}

}
