package com.techmahindra.nad.create_subtask_req;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class CreateSubTask_Marshaling {

	public static Object createJson() throws JsonGenerationException, JsonMappingException, IOException {

		CreateSubTask data = GenerateData.generate();

		// JSON - Marshaling
		ObjectMapper mapper = new ObjectMapper();
		Object json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);
		return json;

	}
}
