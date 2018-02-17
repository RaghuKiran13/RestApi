package com.techmahindra.nad.add_created_proj_to_db;

import java.io.IOException;

import javax.annotation.Generated;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class AddCreatedProjectToDB_Marshaling {

	public static Object createJson() throws JsonGenerationException, JsonMappingException, IOException {

		AddCreatedProjectToDB data = GenerateData.generate();

		// JSON - Marshalling
		ObjectMapper mapper = new ObjectMapper();
		Object json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);
		return json;
	}

}
