package job_agency.job_agency.routes;

import job_agency.job_agency.processors.EmailProcessor;

import org.apache.camel.builder.RouteBuilder;

public class sendEmail extends RouteBuilder {

	@Override
	public void configure() throws Exception {


		from("jms:emailQueue")
		.log("sending email for object ${header.CamelFileName}")
		.process(new EmailProcessor())
		//.setHeader("subject", constant("Result job questionnaire"))
		.recipientList(header("recipient"))
		.log("email sent");
		//.to("smtp://wmpm.group7@smtp.gmail.com:25?password={{emailPassword}}&username={{emailUsername}}&mail.smtp.starttls.enable=true&to=kevin17@gmx.at");

		//from("direct:a").recipientList(header("recipientListHeader").tokenize(","));
	}

}
