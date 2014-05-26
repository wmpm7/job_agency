package job_agency.job_agency.routes;

import job_agency.job_agency.beans.Questionnaire;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;

public class JSONToPOJO extends RouteBuilder{

	@Override
	
	public void configure() throws Exception {
		//Person p;

		from("file:src/data/json?noop=true").
		  unmarshal().json(JsonLibrary.Jackson,Questionnaire.class);
		
	}

}
