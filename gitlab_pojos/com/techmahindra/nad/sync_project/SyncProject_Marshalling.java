package com.techmahindra.nad.sync_project;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import com.techmahindra.nad.generic.GenericLib;



public class SyncProject_Marshalling {
	public static Object createJson() throws JsonGenerationException, JsonMappingException, IOException {

		SyncProject data = GenerateData.generate();

		// JSON - Marshalling
		ObjectMapper mapper = new ObjectMapper();
		Object json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);
		return json;
	}
//	@Test
//	public static void main() throws JsonGenerationException, JsonMappingException, IOException {
//		String[] sData=GenericLib.toReadExcelData(GenericLib.gitLabTestDataPath+"//Gitlab_testdata.xlsx","sync project","tc_01");
//		System.out.println(sData.length);
//	}
}
