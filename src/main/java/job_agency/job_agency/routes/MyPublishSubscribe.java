package job_agency.job_agency.routes;


import job_agency.job_agency.processors.RecipientListGenerator;
import job_agency.job_agency.processors.SubscribeProcess;

import org.apache.camel.builder.RouteBuilder;

public class MyPublishSubscribe extends RouteBuilder{

	public void configure(){
/*
		//from("file://inbound/subscriber?noop=true&delay=15000")
		from("timer://foo2?period=90000")
		.log("send newsletter")
		.pollEnrich("jms:emailBuffer") //?noop=true&idempotentKey=${file:name}-${file:modified}")
		.to("jms:emailBuffer")
		.process(new SubscribeProcess())
		.multicast()
		.recipientList(header("recipients"));
		*/
		from("timer://foo2?period=90000")
		.log("send newsletter")
		.setBody(constant("select email from person union select email from joboffer"))
		.to("jdbc:dataSource")
		.process(new SubscribeProcess())
		.multicast()
		.recipientList(header("recipients"));
	}


}
