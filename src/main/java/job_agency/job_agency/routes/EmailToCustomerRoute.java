package job_agency.job_agency.routes;

import job_agency.job_agency.processors.EmailProcessor;

import org.apache.camel.builder.RouteBuilder;

public class EmailToCustomerRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {


		from("jms:emailQueue")
		.routeId("EMailToCustomer-Route")
		.log("sending email for object ${header.CamelFileName}")
		.process(new EmailProcessor())
		.recipientList(header("recipient"))
		.log("New EMail sent to customer!");

	}

}
