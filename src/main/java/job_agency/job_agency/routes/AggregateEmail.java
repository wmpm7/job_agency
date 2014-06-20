package job_agency.job_agency.routes;


import job_agency.job_agency.processors.MyAggregationStrategy;

import org.apache.camel.builder.RouteBuilder;

public class AggregateEmail extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		//from("file:target/fromApi/reformat")
		from("jms:JobExternQueue")
		.routeId("Aggregator-Route")
		.aggregate(constant(true), new MyAggregationStrategy())
		//.completionTimeout(7000)
		//.completionInterval(8000)
		.completionSize(5)
		.to("file:target/fromApi/aggregated?fileName=external_offers")
		.to("jms:internalandexternal")
		.log("Titles aggregated");
		
	}
}
