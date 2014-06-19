package job_agency.job_agency.routes;

import job_agency.job_agency.processors.GetTitleProcessor;
import job_agency.job_agency.processors.LinkProcessor;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;

public class SearchJobIntern  extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		
		from("jms:internalOfferQueue")
		.process(new GetTitleProcessor())
		.to("jdbc:dataSource")
		.log("All titles read from DB")
		.beanRef("JobInternBean","addToList")
		.beanRef("JobInternBean","getTitleList")
		.setHeader(Exchange.FILE_NAME, constant("internal_offers"))
		.to("file:target/fromApi/aggregated")
		.log("internal offers loaded");
		
		
		/*from("timer://foo?period=3000")
		.routeId("SearchInternJobOffers-Route")
		.setBody(constant("select title from joboffer"))
		.to("jdbc:dataSource")
		.log("All titles read from DB")
		.beanRef("JobInternBean","addToList")
		.beanRef("JobInternBean","getTitleList")
		.setHeader(Exchange.FILE_NAME, constant("internal_offers"))
		.to("file:target/fromApi/aggregated")
		.log("internal offers loaded");*/
		
	}

}
