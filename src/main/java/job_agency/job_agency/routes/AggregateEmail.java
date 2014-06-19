package job_agency.job_agency.routes;


import job_agency.job_agency.processors.MyAggregationStrategy;

import org.apache.camel.builder.RouteBuilder;

public class AggregateEmail extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		from("file:target/fromApi/reformat")
		
		.routeId("Aggregator-Route")
		.aggregate(constant(true), new MyAggregationStrategy())
		.completionInterval(3000)
		
		.to("file:target/fromApi/aggregated?fileName=external_offers")
		.log("Titles aggregated");
		
	}
}
