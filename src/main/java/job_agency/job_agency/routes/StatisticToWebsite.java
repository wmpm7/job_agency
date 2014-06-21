package job_agency.job_agency.routes;

import job_agency.job_agency.processors.JpgAggregation;

import org.apache.camel.builder.RouteBuilder;

public class StatisticToWebsite extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		from("jms:WebsiteQueue")
		.routeId("TextToPdf-Route")
		.delay(3000)	//safety buffer if jpeg not already created 
		.pollEnrich("file://outbound/statistics/graphics?noop=true", 
				new JpgAggregation())
		.convertBodyTo(String.class, "UTF-8")
		.to("fop:application/pdf")
		.to("file://outbound/statistics/pdf")
		.log("PDF file created and stored in outbound/statistics/pdf"); 
	}

}
