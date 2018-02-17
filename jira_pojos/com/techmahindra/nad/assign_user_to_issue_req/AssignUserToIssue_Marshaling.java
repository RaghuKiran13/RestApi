package com.techmahindra.nad.assign_user_to_issue_req;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;



public class AssignUserToIssue_Marshaling {
	
	public static Object createJson() throws JsonGenerationException, JsonMappingException, IOException {

		AssignUserToIssue data = GenerateData.generate();

		// JSON - Marshalling
		ObjectMapper mapper = new ObjectMapper();
		Object json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);
		return json;
	}
	
	
}
