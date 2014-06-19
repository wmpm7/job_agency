package job_agency.job_agency.routes;

import job_agency.job_agency.processors.InsertProcessor;

import org.apache.camel.builder.RouteBuilder;

public class QueueToDBRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		from("jms:FilteredInsertQueue")
		.routeId("QueueToDB-Route")
			.to("jms:emailQueue") //zum testen des email senden, da E-Mail content noch fehlt
			.to("jms:karriereQueue")
			.to("jms:internalOfferQueue")
			.process(new InsertProcessor())
			.to("jdbc:dataSource")
			.log("People from Austria are added to DB --> TABLE Person");
	}

}
