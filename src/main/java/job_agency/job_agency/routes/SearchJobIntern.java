package job_agency.job_agency.routes;

import job_agency.job_agency.processors.GetTitleProcessor;
import org.apache.camel.builder.RouteBuilder;

public class SearchJobIntern  extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		
		from("jms:internalOfferQueue")
		.routeId("SearchJobIntern-Route")
		.to("jms:recipientQueue")
		.process(new GetTitleProcessor())
		.to("jdbc:dataSource")
		.log("All titles read from DB")
		.beanRef("JobInternBean","addToList")
		.beanRef("JobInternBean","getTitleList")
		.to("file:target/fromApi/aggregated")
		.log("internal offers loaded");		
	}

}
