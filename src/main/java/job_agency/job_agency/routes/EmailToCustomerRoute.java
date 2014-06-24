package job_agency.job_agency.routes;

import job_agency.job_agency.processors.EmailProcessor;
import job_agency.job_agency.processors.RecipientAggregation;

import org.apache.camel.builder.RouteBuilder;

public class EmailToCustomerRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		from("jms:emailQueue")
		.routeId("EMailToCustomer-Route")
		.log("sending email for object ${header.CamelFileName}")
		.pollEnrich("jms:recipientQueue", 
				new RecipientAggregation())
		.convertBodyTo(String.class, "UTF-8")
		.process(new EmailProcessor())
		.recipientList(header("recipient"))
		.log("New eMail sent to customer!");

	}

}
