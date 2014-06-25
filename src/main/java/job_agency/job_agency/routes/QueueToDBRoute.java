package job_agency.job_agency.routes;

import job_agency.job_agency.processors.InsertProcessor;

import org.apache.camel.builder.RouteBuilder;

public class QueueToDBRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		from("jms:FilteredInsertQueue")
		.routeId("QueueToDB-Route")
			.to("jms:internalOfferQueue")
			.to("jms:karriereQueue")
			.process(new InsertProcessor())
			.to("jdbc:dataSource")
			.log("People from Austria are added to DB --> TABLE Person");
	}

}
