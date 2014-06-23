package job_agency.job_agency.routes;


import job_agency.job_agency.processors.MyAggregationStrategy;

import org.apache.camel.builder.RouteBuilder;

public class AggregateEmail extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		//from("file:target/fromApi/reformat")
		from("jms:JobExternQueue")
		.routeId("Aggregator-Route")
		
		.aggregate(constant(false), new MyAggregationStrategy())
		
		//.aggregate(constant(false), new MyAggregationStrategy())
		
		.completionTimeout(1000)
		//.completionInterval(3000)
		//.completionSize(5)
		//.end()
		//.header("id")
		// wait for 0.5 seconds to aggregate
		//.batchTimeout(500)
		.to("file:target/fromApi/aggregated?fileName=external_offers")
		//.to("jms:internalandexternal")
		.log("Titles aggregated");
		
	}
}
