package job_agency.job_agency.routes;

import job_agency.job_agency.processors.InsertJobofferProcessor;

import org.apache.camel.builder.RouteBuilder;

public class JobofferQueueToDBRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		from("jms:JobofferQueue")
		.routeId("JobofferQueueToDB-Route")
		.process(new InsertJobofferProcessor())
		.to("jdbc:dataSource")
		.log("New Joboffer added to Derby DB --> TABLE Joboffer");
		
	}

}
