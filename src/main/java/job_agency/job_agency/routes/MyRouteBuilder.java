package job_agency.job_agency.routes;

import org.apache.camel.builder.RouteBuilder;

/**
 * A Camel Java DSL Router
 */
public class MyRouteBuilder extends RouteBuilder {

    /**
     * Let's configure the Camel routing rules using Java code...
     */
    public void configure() {

        // here is a sample which processes the input files
        // (leaving them in place - see the 'noop' flag)
        // then performs content based routing on the message using XPath
        
    	/**
    	 * KEVIN HELLO WORLD
    	 */
    	
		from("file:src/data?noop=true").
		to("jmss:test.MyQueue");					//"jms" is the name of the bean in the camel-context

		from("jmss:test.MyQueue")
		.choice()
			.when(xpath("/person/city = 'London'"))
				.log("UK message")
				.to("file://target/messages/uk")
			.otherwise()
				.log("Other message")   
				.to("file://target/test?noop=true");


		from("file://target/test?noop=true")
			.beanRef("SomeBean")			//beanRef da verweis auf die bean-id in der camel-context
			.to("file://target/emails");

		from("file://target/emails?noop=true")
			.log("Working on file ${header.CamelFileName}")
			.setHeader("subject", constant("My Subject"))
			.to("smtp://wmpm.group7@smtp.gmail.com:25?password=blubb123&username=wmpm.group7&mail.smtp.starttls.enable=true&to=kevin17@gmx.at");

    }

}
