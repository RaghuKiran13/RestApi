package com.techmahindra.nad.add_created_proj_to_db;

import java.util.ArrayList;
import java.util.List;

public class GenerateData {
	
	public static AddCreatedProjectToDB generate(){
		
		
		MicroService microservice = new MicroService();
		microservice.setKey("");
		microservice.setName("");
		List<String> approvers = new ArrayList<>();
		approvers.add("");
		microservice.setApprovers(approvers);
		
		List<MicroService> microservies = new ArrayList<>();
		microservies.add(microservice);
				
		AddCreatedProjectToDB createCreatedProjToDB = new AddCreatedProjectToDB();
		createCreatedProjToDB.setProjectId("");
		createCreatedProjToDB.setKey("");
		
		createCreatedProjToDB.setMicroServices(microservies);
		
		return createCreatedProjToDB;
	}

}
