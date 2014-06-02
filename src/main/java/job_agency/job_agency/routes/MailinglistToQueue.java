package job_agency.job_agency.routes;

import org.apache.camel.builder.RouteBuilder;

public class MailinglistToQueue extends RouteBuilder {

	@Override
	public void configure() throws Exception {


		from("file://inbound/subscriber?noop=true")
		.to("jms:emailBuffer");

	}

}
