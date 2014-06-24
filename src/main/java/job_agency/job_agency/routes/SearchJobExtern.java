package job_agency.job_agency.routes;

import job_agency.job_agency.processors.CreateDirectoryProcessor;
import job_agency.job_agency.processors.LinkProcessor;

import org.apache.camel.builder.RouteBuilder;

public class SearchJobExtern extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		
		from("jms:karriereQueue")  
		.routeId("SearchJobExtern-Route")
			.process(new LinkProcessor())
			.process(new CreateDirectoryProcessor())
			.recipientList(header("recipient"))
			.log("Karriere.at wurde abgefragt!")
		.delay(3000)
		.log("karriere offers loaded")
			.beanRef("JobExternBean","reformat")
			.to("file:target/fromApi/reformat");	
	}	
}
