package job_agency.job_agency.routes;

import job_agency.job_agency.processors.InsertProcessor;

import org.apache.camel.builder.RouteBuilder;

public class QueueToDBRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		from("jms:FilteredInsertQueue")
			.to("jms:emailQueue") //zum testen des email senden
			.process(new InsertProcessor())
		//.to("jms:awef");
			.to("jdbc:dataSource");
	}

}
