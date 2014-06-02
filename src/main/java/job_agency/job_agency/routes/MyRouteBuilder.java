package job_agency.job_agency.routes;

import org.apache.camel.builder.RouteBuilder;

public class MyRouteBuilder extends RouteBuilder {

	public void configure() {
    	/**
    	 * KEVIN HELLO WORLD + EMAIL
    	 */
    	
    	//routing 1 file2queue
		//from("file:src/data?noop=true").
		//to("jms:test.MyQueue");					//"jms" is the name of the bean in the camel-context


		//routing 2 queue2file
		/*from("jms:test.MyQueue")
		.choice()
			.when(xpath("/person/city = 'London'"))
				.log("UK message")
				.to("file://target/messages/uk")
			.otherwise()
				.log("Other message")   
				.to("file://target/test?noop=true");*/

		//routing 3 file2file with bean
		//from("file://target/test?noop=true")
		//	.beanRef("SomeBean")					//beanRef da verweis auf die bean-id in der camel-context
		//	.to("file://target/emails");

		//routing 4 file2email
		//from("file://target/emails?noop=true")
		//from("file:src/data/test?noop=true")
			//.log("Working on file ${header.CamelFileName}")
			//.setHeader("subject", constant("My Subject"))
			//.to("smtp://wmpm.group7@smtp.gmail.com:25?password=blubb123&username=wmpm.group7&mail.smtp.starttls.enable=true&to=cbartmann@gmx.at;irene.eichinger@aon.at");
			//email-adresse ändern zum testen. brauch keinen spam :P
/*
		.when(xpath("/person/city = 'London'"))
		.log("UK message")
		.to("file://target/messages/uk")
		.otherwise()
		.log("Other message")   
		.to("file://target/test?noop=true");

		//routing 3 file2file with bean
		from("file://target/test?noop=true")
		.beanRef("SomeBean")					//beanRef da verweis auf die bean-id in der camel-context
		.to("file://target/emails");

		//routing 4 file2email
		from("file://target/emails?noop=true")
		.log("Working on file ${header.CamelFileName}")
		.setHeader("subject", constant("My Subject"))
		//.to("smtp://wmpm.group7@smtp.gmail.com:25?password=blubb123&username=wmpm.group7&mail.smtp.starttls.enable=true&to=kevin17@gmx.at");
		.to("smtp://wmpm.group7@smtp.gmail.com:25?password={{emailPassword}}&username={{emailUsername}}&mail.smtp.starttls.enable=true&to=kevin17@gmx.at");
		//email-adresse ändern zum testen. brauch keinen spam :P*/
	}
}
