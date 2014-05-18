package job_agency.job_agency;

import org.apache.camel.builder.RouteBuilder;

public class MailRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		from("file:src/data/emails?noop=true")
	    .log("Working on file ${header.CamelFileName}")
	    .setHeader("subject", constant("My Subject"))
	    .to("smtp://wmpm.group7@smtp.gmail.com:25?password=blubb123&username=wmpm.group7&mail.smtp.starttls.enable=true&to=kevin17@gmx.at");
	}
	
//	private void doSomething()
//	{
////http://camel.apache.org/mail.html
//	
////smtp://host[:port]?password=somepwd&username=someuser
////smtp://mycompany.mailserver:30?password=tiger&username=scott
//	// create an exchange with a normal body and attachment to be produced as email
//		
//		//http://camel.apache.org/tutorial-example-reportincident.html
//		
//	Endpoint endpoint = context.getEndpoint("smtp://james@mymailserver.com?password=secret");
//	 
//	// create the exchange with the mail message that is multipart with a file and a Hello World text/plain message.
//	Exchange exchange = endpoint.createExchange();
//	Message in = exchange.getIn();
//	in.setBody("Hello World");
//	in.addAttachment("logo.jpeg", new DataHandler(new FileDataSource("src/test/data/logo.jpeg")));
//	 
//	// create a producer that can produce the exchange (= send the mail)
//	Producer producer = endpoint.createProducer();
//	// start the producer
//	producer.start();
//	// and let it go (processes the exchange by sending the email)
//	producer.process(exchange);
//	
//	
//	
//	
//	Map<String, Object> map = new HashMap<String, Object>();
//	map.put("To", "davsclaus@apache.org");
//	map.put("From", "jstrachan@apache.org");
//	map.put("Subject", "Camel rocks");
//	 
//	String body = "Hello Claus.\nYes it does.\n\nRegards James.";
//	template.sendBodyAndHeaders("smtp://davsclaus@apache.org", body, map);
//	}
//	
//	private void generateEmailBodyAndStoreAsFile(InputReportIncident parameters) {
//	    // generate the mail body using velocity template
//	    // notice that we just pass in our POJO (= InputReportIncident) that we
//	    // got from Apache CXF to Velocity.
//	    Object response = template.sendBody("velocity:MailBody.vm", parameters);
//	    // Note: the response is a String and can be cast to String if needed
//	 
//	    // store the mail in a file
//	    String filename = "mail-incident-" + parameters.getIncidentId() + ".txt";
//	    template.sendBodyAndHeader("file://target/subfolder", response, FileComponent.HEADER_FILE_NAME, filename);
//	}
//	
//	private void sendEmail(String body) {
//	    // send the email to your mail server
//	    String url = "smtp://someone@localhost?password=secret&to=incident@mycompany.com";
//	    template.sendBodyAndHeader(url, body, "subject", "New incident reported");
//	}

}

