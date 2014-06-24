package job_agency.job_agency.routes;


import job_agency.job_agency.processors.MergeProcessor;

import org.apache.camel.builder.RouteBuilder;

public class AggregateAllOffers extends RouteBuilder{

	@Override
	public void configure() throws Exception {

		from("file:target/fromApi/reformat")
		.routeId("Aggregator_all-Route")
		.delay(2000)
		.process(new MergeProcessor())
		.to("file:target/fromApi/finish?fileName=all_offers")
		.to("jms:emailQueue")
		.log("Internal and external offers aggregated");
		
	}
}
