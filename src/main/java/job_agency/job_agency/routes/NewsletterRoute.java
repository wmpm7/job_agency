package job_agency.job_agency.routes;

import job_agency.job_agency.processors.SubscribeProcessor;

import org.apache.camel.builder.RouteBuilder;

public class NewsletterRoute extends RouteBuilder{

	public void configure(){

		from("timer://foo2?period=90000")
		.routeId("Newsletter-Route")
		.delay(10000)
		.setBody(constant("select email from person where newsletter='true' union select email from joboffer where newsletter='true'"))
		//DB FLAG fehlt ob subscribed
		.to("jdbc:dataSource")
		.process(new SubscribeProcessor())
		.multicast()
		.recipientList(header("recipients"))
		.log("Newsletters sent to subscribed people!");
	}


}
