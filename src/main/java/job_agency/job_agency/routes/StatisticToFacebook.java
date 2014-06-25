package job_agency.job_agency.routes;

import job_agency.job_agency.processors.FBProcessor;

import org.apache.camel.builder.RouteBuilder;

public class StatisticToFacebook extends RouteBuilder{

	//private static final Logger LOG = LoggerFactory.getLogger(StatisticToFacebook.class);
	
	@Override
	public void configure() throws Exception {

		onException(Exception.class).handled(true)
		.log("Facebook error!")
		.to("file:target/fblogs");
		
		from("file://outbound/statistics?noop=true&idempotentKey=${file:name}-${file:modified}")
		.routeId("StatisticToFacebook-Route")
		.delay(120000)
		.convertBodyTo(String.class, "UTF-8")
		.process(new FBProcessor())
		.recipientList(header("recipient"))
		.log("Die Statistik wurde auf FB gepostet!");

	}

}