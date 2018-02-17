package com.techmahindra.nad.create_new_project_req;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;




public class CreateNewProject_Marshaling {
	
	public static Object createJson() throws JsonGenerationException, JsonMappingException, IOException {

		CreateNewProject data = GenerateData.generate();

		// JSON - Marshalling
		ObjectMapper mapper = new ObjectMapper();
		Object json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);
		return json;
	}
	
}
