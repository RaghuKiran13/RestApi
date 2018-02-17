package com.techmahindra.nad.create_project;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;



public class CreateProject_Marshalling {
	public static Object createJson() throws JsonGenerationException, JsonMappingException, IOException {

		CreateProject data = GenerateData.generate();

		// JSON - Marshalling
		ObjectMapper mapper = new ObjectMapper();
		Object json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);
		return json;
	}
//	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
//		System.out.println(createJson());
//	}
}
