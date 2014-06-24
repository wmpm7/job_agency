package job_agency.job_agency.routes;

import job_agency.job_agency.processors.FBProcessor;

import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StatisticToFacebook extends RouteBuilder{

	private static final Logger LOG = LoggerFactory.getLogger(StatisticToFacebook.class);
	
	@Override
	public void configure() throws Exception {
//		from("file://src/data/test?noop=true")
//		  .to("facebook://postStatusMessage?"
//		  		+ "message=blub"
//		  		+ "&oAuthAccessToken=CAADe3mZCA6xsBAHqTXCc66d4ZAqPy9apCSEAfziR7irRN6DHYuvyzu2BBVn2ZAc2krC5MlgtqINhxu6QjjMBkH1rNm6LYmfeKZAZCJDJKkZCqEm3oZAG8wG166b01AeemDWbcNHyCrjZBzyuJJ8cOojz3ZCxdXtuPF1CYZBEWYa7zT1lqCg7DJeCLBlas7aQlxWtcZD"
//		  		+ "&oAuthAppId=245046939020059"
//		  		+ "&oAuthAppSecret=fba916c9088b2776937f4715dd0e5b00");
		onException(Exception.class).handled(true)
		.log("Facebook error!")
		.to("file:target/fblogs");
		
		from("file://outbound/statistics?noop=true&idempotentKey=${file:name}-${file:modified}")
		.routeId("StatisticToFacebook-Route")
		.delay(10000)
		.convertBodyTo(String.class, "UTF-8")
		.process(new FBProcessor())
		.recipientList(header("recipient"))
		.log("Die Statistik wurde auf FB gepostet!");

	}

}