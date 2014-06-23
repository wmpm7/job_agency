package job_agency.job_agency.routes;


import job_agency.job_agency.processors.AggregateAllStrategy;

import org.apache.camel.builder.RouteBuilder;

public class AggregateAllOffers extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		from("file:target/fromApi/aggregated")
		
		.routeId("Aggregator_all-Route")
		.aggregate(constant(true), new AggregateAllStrategy())
		//.completionInterval(10000)
		.completionSize(2)
		.to("file:target/fromApi/finish?fileName=all_offers")
		.to("jms:emailQueue")
		.log("Internal and external offers aggregated");
		
	}
}
